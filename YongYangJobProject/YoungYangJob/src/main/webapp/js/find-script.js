$(".tab-id-find").click(function(){
    $(this).css({
        "border-bottom" : "0",
        "background-color" : "white"
    });
    $(".tab-pw-find").css({
        "border-bottom" : "1px solid #000",
        "background-color" : "#888"
    });
    $(".pw-find-box").hide();
    $(".id-find-box").show();
});

$(".tab-pw-find").click(function(){
    $(this).css({
        "border-bottom" : "0",
        "background-color" : "white"
    });
    $(".tab-id-find").css({
        "border-bottom" : "1px solid #000",
        "background-color" : "#888"
    });

    $(".id-find-box").hide();
    $(".pw-find-box").show();
});