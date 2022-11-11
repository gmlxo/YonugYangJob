$(".tab-id").click(function(){
    $(this).css({
        "border-bottom" : "0",
        "background-color" : "white"
    });
    $(".tab-password").css({
        "border-bottom" : "1px solid #000",
        "background-color" : "#888"
    });
    $(".password-find").hide();
    $(".id-find").show();
});

$(".tab-password").click(function(){
    $(this).css({
        "border-bottom" : "0",
        "background-color" : "white"
    });
    $(".tab-id").css({
        "border-bottom" : "1px solid #000",
        "background-color" : "#888"
    });

    $(".id-find").hide();
    $(".password-find").show();
});

function openPop() {
    $("#pop").show("slow");
}

function closePop() {
    $("#pop").hide("fast");
}