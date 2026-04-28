from flask import Flask, request, jsonify, send_file
from flask_cors import CORS
from google import genai
from dotenv import load_dotenv
import os
import subprocess
import json

app = Flask(__name__)
load_dotenv()

client = genai.Client(api_key=os.getenv("GEMINI_API_KEY"))

CORS(app)

# Path to the compiled JAR (built by `mvn package`)
JAR_PATH = os.path.join(os.path.dirname(__file__), "target", "todo-app.jar")

@app.route('/')
def home():
    return send_file('index.html')

@app.route('/generate_subtasks', methods=['POST'])
def generate_subtasks():
    task = request.json.get('task')

    prompt = f"""
    Break the task into EXACTLY 5 step-by-step actionable subtasks.

    Rules:
    - Each subtask must be ONE short sentence
    - No paragraphs allowed
    - No explanations
    - No academic writing style
    - Must be numbered steps (1 to 5)
    - Must represent execution steps, not descriptions

    Task: {task}
    """

    response = client.models.generate_content(
        model="gemini-2.5-flash",
        contents=prompt
    )

    subtasks = [
        line.strip("12345. -").strip()
        for line in response.text.split("\n")
        if line.strip()
    ]

    return jsonify({
        "task": task,
        "subtasks": subtasks
    })


@app.route('/delete_task', methods=['POST'])
def delete_task():
    """
    Delegates deletion to TodoList.deleteTask via the compiled JAR.

    Expects JSON:
        {
            "taskId": 2,
            "tasks": [
                {"id": 1, "title": "Learn Java"},
                {"id": 2, "title": "Complete DevOps project"},
                {"id": 3, "title": "Write JUnit tests"}
            ]
        }

    Returns whatever DeleteTaskRunner prints (JSON):
        { "deleted": true,  "taskId": 2, "tasks": [...remaining...] }
        { "deleted": false, "taskId": 9, "tasks": [...unchanged...] }
    """
    data = request.json
    if not data or 'taskId' not in data:
        return jsonify({"error": "taskId is required"}), 400

    task_id  = data['taskId']
    tasks    = data.get('tasks', [])   # list of {id, title}

    # Build args for DeleteTaskRunner: <taskId> <id,title> <id,title> ...
    args = [str(task_id)]
    for t in tasks:
        # Comma-separate id and title; DeleteTaskRunner splits on first comma
        args.append(f"{t['id']},{t['title']}")

    try:
        result = subprocess.run(
            ["java", "-jar", JAR_PATH] + args,
            capture_output=True,
            text=True,
            timeout=10
        )
        output = result.stdout.strip()
        return jsonify(json.loads(output))

    except FileNotFoundError:
        return jsonify({"error": "JAR not found. Run 'mvn package' first."}), 500
    except subprocess.TimeoutExpired:
        return jsonify({"error": "Java process timed out."}), 500
    except json.JSONDecodeError:
        return jsonify({"error": "Invalid output from JAR.", "raw": output}), 500


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=False)
