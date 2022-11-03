$("#ser").click(function (e) { 
    alert("DB : 수민이 지원");
});

$(".search-box-popUp").hover(function(){
    $(".search-box-popUp input[type=submit]").css("background-color", "rgb(51, 51, 217)");
}, function(){
    $(".search-box-popUp input[type=submit]").css("background-color", "");
});