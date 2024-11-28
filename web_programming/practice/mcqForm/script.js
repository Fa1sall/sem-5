const mcqForm = document.getElementById('mcqForm');
const resultDiv = document.getElementById('result');
function submitQuiz(){
    let correctAnswers = 0;

    const q1 = document.querySelector('input[name="q1"]:checked');
    const q2 = document.querySelector('input[name="q2"]:checked');

    if(q1 && q1.value==="correct"){
        correctAnswers++;
    }
    if(q2 && q2.value==="correct"){
        correctAnswers++;
    }

    resultDiv.innerHTML = `You answered ${correctAnswers} out of 2 question`;
    mcqForm.onsubmit = () => false;
}