/* 지역 */
var region = [".seoul", ".gyeonggi", ".incheon", ".busan", ".daegu", ".gwangju", ".daejeon", ".ulsan", ".sejong", ".gangwon", ".gyeongnam", ".gyeongbuk", ".chungnam", ".jeju", ".national"]

/* 행정구역 */
var seoul = [".all_seoul", ".gangnam", ".gangdong", ".ganbuk", ".gangseo", ".gwanak", ".gwangjin", ".guro", ".geumcheon", ".nowon", ".dobong", ".dongdaemun", ".otherthan-seoul"];
var gyeonggi = [".all_gyeonggi", ".SouthernGyeonggi", ".suwon", ".yongin", ".seongnam", ".bucheon", ".hwaseongCity", ".ansan", ".anyang", ".pyeongtaek", ".siheung", ".gimpoCity", ".gwangju", ".gwangmyeong", ".gunpo", ".hanam", ".osan", ".icheon", ".anseong", ".uiwang", ".yangpyeong", ".yeoju", ".otherthan-seoul"];
var incheon = [".ganghwa", ".ongjin", ".jung_in", ".dong_in", ".michuholgu", ".yeonsu", ".namdong", ".bupyeong", ".gyeyang", ".western"];
var busan = [".jung_bu", ".dong_bu", ".yeongdo", ".busanjin", ".dongnae", ".nam_bu", ".buk", ".haeundae", ".sahagu", ".geumjeong", ".gangseo", ".yeonje", ".swimmingPool", ".sasanggu", ".gijang"];
var daegu = [];
var gwangju = [];
var daejeon = [];
var ulsan = [];
var sejong = [];
var gangwon = [];
var gyeongnam = [];
var gyeongbuk = [];
var jeonnnam = [];
 
$(".region-jobs").click(function () {
    $(this).css({
        "border-bottom": "0",
        "background-color": "white"
    });
    $(".Job-jobs").css({
        "border-bottom": "1px solid #000",
        "background-color": "#888"
    });
    $(".test").hide();
    $(".region-box").show();
});

$(".Job-jobs").click(function () {
    $(this).css({
        "border-bottom": "0",
        "background-color": "white"
    });
    $(".region-jobs").css({
        "border-bottom": "1px solid #000",
        "background-color": "#888"
    });

    $(".region-box").hide();
    $(".test").show();
});