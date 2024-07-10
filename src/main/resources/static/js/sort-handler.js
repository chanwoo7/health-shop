// 페이지 로드할 때마다 선택한 정렬값으로 드롭다운 텍스트 초기화
document.addEventListener('DOMContentLoaded', function() {
    const sortValue = document.getElementById('sortInput').value;
    let sortText = '정렬';
    if (sortValue === 'idDesc') sortText = '신상품순';
    else if (sortValue === 'priceDesc') sortText = '높은 가격순';
    else if (sortValue === 'priceAsc') sortText = '낮은 가격순';
    else if (sortValue === 'discountRateDesc') sortText = '할인율순';

    document.getElementById('sortDropdownText').innerText = sortText;
});