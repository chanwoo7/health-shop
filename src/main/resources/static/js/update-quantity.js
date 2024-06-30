function updateQuantity(change) {
    const input = document.getElementById('inputQuantity');
    let currentValue = parseInt(input.value);
    currentValue += change;

    if (currentValue < 1) {
        currentValue = 1;
    } else if (currentValue > 100) {
        currentValue = 100;
    }

    input.value = currentValue;
    document.getElementById('decreaseQuantity').disabled = currentValue === 1;
    document.getElementById('increaseQuantity').disabled = currentValue === 100;
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('decreaseQuantity').disabled = true; // Initially disable the decrease button
});