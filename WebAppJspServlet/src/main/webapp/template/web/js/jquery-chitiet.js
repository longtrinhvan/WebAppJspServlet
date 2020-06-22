$(document).ready(function () {
  var mini_img_01 = $("#mini-img-pr-rw-01").attr("src");
  var mini_img_02 = $("#mini-img-pr-rw-02").attr("src");
  var mini_img_03 = $("#mini-img-pr-rw-03").attr("src");
  var mini_img_04 = $("#mini-img-pr-rw-04").attr("src");
  var mini_img_05 = $("#mini-img-pr-rw-05").attr("src");
  $("#mini-img-pr-rw-01").click(function () {
    $("#mini-img-pr-rw-00").attr("src", mini_img_01);
  });
  $("#mini-img-pr-rw-02").click(function () {
    $("#mini-img-pr-rw-00").attr("src", mini_img_02);
  });
  $("#mini-img-pr-rw-03").click(function () {
    $("#mini-img-pr-rw-00").attr("src", mini_img_03);
  });
  $("#mini-img-pr-rw-04").click(function () {
    $("#mini-img-pr-rw-00").attr("src", mini_img_04);
  });
  $("#mini-img-pr-rw-05").click(function () {
    $("#mini-img-pr-rw-00").attr("src", mini_img_05);
  });
});
$(document).ready(function () {
  var arr = [1, 2, 3, 4];
  $("#img-prl-left").click(function () {
    var flag = 0;
    $.each(arr, function (index, value) {
      if ($("#slide-pr-0" + value).css("display") === "block") {
        flag = value;
      }
    });
    if (flag - 1 === 0) {
      $("#slide-pr-04").css("display", "block");
    } else {
      $.each(arr, function (index, value) {
        if (flag - 1 === value) {
          $("#slide-pr-0" + value).css("display", "block");
        }
        else {
          $("#slide-pr-0" + value).css("display", "none");
        }
      });
    }
  });
  $("#img-prl-right").click(function () {
    var flag = 0;
    $.each(arr, function (index, value) {
      if ($("#slide-pr-0" + value).css("display") === "block") {
        flag = value;
      }
    });
    $.each(arr, function (index, value) {
      $("#slide-pr-0" + value).css("display", "none");
    });
    if (flag === arr.length) {
      $("#slide-pr-01").css("display", "block");
    } else {
      $.each(arr, function (index, value) {
        if (flag + 1 === value) {
          $("#slide-pr-0" + value).css("display", "block");
        }
      });
    }
  });
});
$(document).ready(function () {
  $("#fullparameter").click(function () {
    $("#full-para").css("display", "block");
  });
  var full_para=1;
  $(".full-para-00").mouseenter(function(){
    full_para=1;
  });
  $(".full-para-00").mouseleave(function(){
    full_para=0;
  });
  $("#full-para").click(function () {
    if(full_para===0){
      $("#full-para").css("display", "none");
    }
  });
});


