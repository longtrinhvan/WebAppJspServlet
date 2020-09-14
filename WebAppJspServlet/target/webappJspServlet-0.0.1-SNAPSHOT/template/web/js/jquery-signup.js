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


