$(".Logo").click(function(){
  $(".Logo").animate({top:'0'},"slow");
  $(".item").fadeIn("slow",function(){
    $(".items").css("display","block");
    $(".item").css("display","block");
  })
  }
);
