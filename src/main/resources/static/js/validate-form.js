function validateCreateItemForm() {
    return confirm("정말로 이 내용대로 상품을 생성하시겠습니까?");
}

function validateUpdateItemForm() {
    return confirm("정말로 변경사항을 반영하시겠습니까?");
}

function validateDeleteItemForm() {
    return confirm("정말로 이 상품을 삭제하시겠습니까?\n삭제 후에는 복구할 수 없습니다.");
}