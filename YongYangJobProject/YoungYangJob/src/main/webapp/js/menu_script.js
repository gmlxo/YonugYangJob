// footer db 아이콘 눌렀을때 알람
$("#ser").click(function (e) { 
    alert('수민이 지원');    
});

// postings sysdate 이전 날짜를 선택 못하게 하기
var now_utc = Date.now()
var timeOff = new Date().getTimezoneOffset()*60000;
var today = new Date(now_utc-timeOff).toISOString().split("T")[0];
document.getElementById("sysdate").setAttribute("min", today);