// 이미지 슬라이드 동작
var slide = $(".slide > img");
var sno = 0;
var eno = slide.length - 1;
var timer = setInterval("autoslide()", 3000); // 3초마다 모션함수 실행

// 모션함수
function autoslide() {
    
    // 첫번째 이미지 사라지기
    $(slide[sno]).stop().animate(
        {
            left: "100%"
        },
        1000,
        function() {
            $(this).css({
            
             left: "-100%"
            });
        }
    );

    // 나타날 이미지 카운트
    sno++;
    if(sno > eno) {
        sno = 0;
    }

    // 두번째 이미지 나타나기
    $(slide[sno]).stop().animate({
        left: "0"
    }, 1000);
};