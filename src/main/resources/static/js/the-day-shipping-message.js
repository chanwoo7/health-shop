function getNextMonday(date) {
    const day = date.getDay();
    const diff = day === 0 ? 1 : 7 - day + 1;
    const nextMonday = new Date(date);
    nextMonday.setDate(date.getDate() + diff);
    return nextMonday;
}

function formatDate(date) {
    const day = String(date.getDate()).padStart(2, '0');
    const month = String(date.getMonth() + 1).padStart(2, '0');
    return `${month}/${day}`;
}

function formatTimeLeft(seconds) {
    const hours = String(Math.floor(seconds / 3600)).padStart(2, '0');
    const minutes = String(Math.floor((seconds % 3600) / 60)).padStart(2, '0');
    const secs = String(seconds % 60).padStart(2, '0');
    return `${hours}:${minutes}:${secs}`;
}

function updateMessage() {
    const now = new Date();
    const today = now.getDay();  // 0 = 일요일, 1 = 월요일, ..., 6 = 토요일
    const messageElement = document.getElementById('theDayShippingMessage');

    if (today === 0 || today === 6) {  // 일요일 또는 토요일
        const nextMonday = getNextMonday(now);
        messageElement.textContent = `당일 발송 휴무일. 지금 주문 시 ${formatDate(nextMonday)}에 발송됩니다.`;
    } else {
        const twoPmToday = new Date(now);
        twoPmToday.setHours(14, 0, 0, 0);  // 오후 2시

        if (now < twoPmToday) {
            const timeLeft = Math.floor((twoPmToday - now) / 1000);  // 남은 초
            messageElement.textContent = `당일 발송 가능. ${formatTimeLeft(timeLeft)} 내에 주문 시, 오늘(${formatDate(now)}) 발송됩니다.`;
        } else {
            const twoPmTomorrow = new Date(now);
            twoPmTomorrow.setDate(now.getDate() + 1);
            twoPmTomorrow.setHours(14, 0, 0, 0);  // 오후 2시
            const timeLeft = Math.floor((twoPmTomorrow - now) / 1000); // 남은 초
            const tomorrow = new Date(now);
            tomorrow.setDate(now.getDate() + 1);
            messageElement.textContent = `당일 발송 종료. ${formatTimeLeft(timeLeft)} 내에 주문 시, 내일(${formatDate(tomorrow)}) 발송됩니다.`;
        }
    }
}

updateMessage();
setInterval(updateMessage, 1000); // 매 초마다 업데이트
