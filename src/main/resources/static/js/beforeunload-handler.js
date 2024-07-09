function handleBeforeUnload(event) {
    event.preventDefault();
    event.returnValue = '';
}

document.addEventListener('DOMContentLoaded', (event) => {
    const forms = document.querySelectorAll('form');

    forms.forEach(form => {
        const formElements = form.querySelectorAll('input, select, textarea');

        formElements.forEach(element => {
            element.addEventListener('input', (event) => {
                window.addEventListener('beforeunload', handleBeforeUnload);
            });

            element.addEventListener('change', (event) => {
                window.addEventListener('beforeunload', handleBeforeUnload);
            });
        });

        form.addEventListener('submit', (event) => {
            window.removeEventListener('beforeunload', handleBeforeUnload);
        });
    });
});