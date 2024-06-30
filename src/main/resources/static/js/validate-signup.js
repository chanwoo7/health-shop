function validatePasswords() {
    const password = document.querySelector("[name='password']").value;
    const confirmPassword = document.getElementById("confirmPassword").value;
    const errorDiv = document.getElementById("confirmPasswordError");

    if (password !== confirmPassword) {
        errorDiv.style.display = "block";
        return false;  // 폼 제출 거부
    } else {
        errorDiv.style.display = "none";
        return true;  // 폼 제출 허용
    }
}

function validateForm() {
    const passwordValid = validatePasswords();
    const termsChecked = document.getElementById("terms").checked;
    const termsErrorDiv = document.getElementById("termsError");

    if (!termsChecked) {
        termsErrorDiv.style.display = "block";
    } else {
        termsErrorDiv.style.display = "none";
    }

    return passwordValid && termsChecked;
}