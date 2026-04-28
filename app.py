from flask import Flask, request, jsonify
from flask import send_file
from flask_cors import CORS
from google import genai
from google.genai import types
from dotenv import load_dotenv
import os

app = Flask(__name__)
load_dotenv()

client = genai.Client(api_key=os.getenv("GEMINI_API_KEY"))

CORS(app)

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

if __name__ == "__main__":
    app.run(debug=True)