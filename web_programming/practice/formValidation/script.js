function validateForm(event){
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const address = document.getElementById('address').value;

    const nameError = document.getElementById('nameError');
    const emailError = document.getElementById('emailError');
    const passwordError = document.getElementById('passwordError');
    const addressError = document.getElementById('addressError');

    nameError.textContent = "";
    emailError.textContent = "";
    passwordError.textContent = "";
    addressError.textContent = "";

    event.preventDefault();

    let isValid = true;

    if(name==="" || /\d/.test(name)){
        nameError.textContent = "Enter a valid name";
        isValid = false;
    }
    if(email==="" || !email.includes('@')){
        emailError.textContent = "Enter valid Email (Must Include @)";
        isValid = false;
    }
    if(password==="" || password.length<6){
        passwordError.textContent = "Enter valid password (Length>6)";
        isValid = false;
    }
    if(address===""){
        addressError.textContent = "Enter valid address";
        isValid = false;
    }

    if(isValid){
        alert('Form Submitted Successfully!');
    }

    return isValid;
}