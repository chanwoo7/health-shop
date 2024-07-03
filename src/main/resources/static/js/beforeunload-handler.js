function handleBeforeUnload(event) {
    event.preventDefault();
    event.returnValue = '';
}

document.addEventListener('DOMContentLoaded', (event) => {
    const form = document.querySelector('form');

    form.addEventListener('change', (event) => {
        window.addEventListener('beforeunload', handleBeforeUnload);
    });

    // 제출할 때는 이벤트 리스너 제거
    form.addEventListener('submit', (event) => {
        window.removeEventListener('beforeunload', handleBeforeUnload);
    });
});