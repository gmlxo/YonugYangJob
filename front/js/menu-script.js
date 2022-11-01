$("#ser").click(function (e) { 
    alert('수민이 지원');    
});

$(".search-box").hover(function(){
    $(".search-box input[type=submit]").css("background-color", "rgb(51, 51, 217)");
}, function(){
    $(".search-box input[type=submit]").css("background-color", "");
});