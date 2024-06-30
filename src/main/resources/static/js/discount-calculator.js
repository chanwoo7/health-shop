document.addEventListener('DOMContentLoaded', (event) => {
    const priceInput = document.getElementById('price');
    const discountRateInput = document.getElementById('discountRate');
    const discountedPriceInput = document.getElementById('discountedPrice');

    function calculateDiscountedPrice() {
        const price = parseFloat(priceInput.value);
        const discountRate = parseFloat(discountRateInput.value);
        if (!isNaN(price) && !isNaN(discountRate) && discountRate >= 0 && discountRate < 100) {
            const discountedPrice = price * (1 - discountRate / 100);
            discountedPriceInput.value = discountedPrice.toLocaleString(undefined, {maximumFractionDigits: 0}) + '원';
        } else {
            discountedPriceInput.value = '';
        }
    }

    priceInput.addEventListener('input', calculateDiscountedPrice);
    discountRateInput.addEventListener('input', calculateDiscountedPrice);

    // 초기 로드 시 할인가 계산
    calculateDiscountedPrice();
});