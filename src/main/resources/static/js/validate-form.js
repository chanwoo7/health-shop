function validateForm() {
    window.removeEventListener('beforeunload', handleBeforeUnload);
    return confirm("정말로 변경사항을 반영하시겠습니까?");
}