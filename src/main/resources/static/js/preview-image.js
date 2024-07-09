function previewImage(event) {
    const reader = new FileReader();
    reader.onload = function(){
        const output = document.getElementById('imgPreview');
        output.src = reader.result;
        output.style.display = 'block';  // 상품 생성 폼에서 이미지 미리보기 보이도록 설정
    };
    reader.readAsDataURL(event.target.files[0]);
}