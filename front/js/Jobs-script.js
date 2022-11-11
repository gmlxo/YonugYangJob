$(".region-jobs").click(function(){
    $(this).css({
        "border-bottom" : "0",
        "background-color" : "white"
    });
    $(".Job-jobs").css({
        "border-bottom" : "1px solid #000",
        "background-color" : "#888"
    });
    $(".test").hide();
    $(".region-box").show();
});

$(".Job-jobs").click(function(){
    $(this).css({
        "border-bottom" : "0",
        "background-color" : "white"
    });
    $(".region-jobs").css({
        "border-bottom" : "1px solid #000",
        "background-color" : "#888"
    });

    $(".region-box").hide();
    $(".test").show();
});