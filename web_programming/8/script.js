let timeLeft = 300; // Time in seconds (5 minutes)

const timerElement = document.getElementById("time");
const mcqForm = document.getElementById("mcqForm");
const resultDiv = document.getElementById("result");

function startTimer() {
    const timer = setInterval(() => {
        if (timeLeft <= 0) {
            clearInterval(timer);
            submitQuiz();
        } else {
            timeLeft--;
            let minutes = Math.floor(timeLeft / 60);
            let seconds = timeLeft % 60;
            seconds = seconds < 10 ? '0' + seconds : seconds;
            timerElement.textContent = `${minutes}:${seconds}`;
        }
    }, 1000);
}

function submitQuiz() {
    let correctAnswers = 0;

    // Checking the selected answers
    const q1 = document.querySelector('input[name="q1"]:checked');
    const q2 = document.querySelector('input[name="q2"]:checked');
    const q3 = document.querySelector('input[name="q3"]:checked');
    const q4 = document.querySelector('input[name="q4"]:checked');

    if (q1 && q1.value === "Correct") correctAnswers++;
    if (q2 && q2.value === "Correct") correctAnswers++;
    if (q3 && q3.value === "Correct") correctAnswers++;
    if (q4 && q4.value === "Correct") correctAnswers++;

    // Show the result
    resultDiv.innerHTML = `You answered ${correctAnswers} out of 4 questions correctly.`;
    
    // Disable form submission
    mcqForm.onsubmit = () => false;
}

// Start the timer when the page loads
window.onload = startTimer;

