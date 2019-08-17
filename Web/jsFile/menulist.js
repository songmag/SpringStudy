
$(document).ready(function(){
  var a_tag = "<a></a>"
  var p_tag = "<p></p>"
  $.get("/menulist/all",function(list,status){
      $.each(list,function(key,value){
        alert('key' + key + 'value' + value);
      })
    })
});
