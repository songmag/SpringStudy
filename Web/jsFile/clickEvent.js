function submit_check(){
    var input_tag = document.getElementsByTagName("input");
    if(input_tag[0].value === "")
    {
      alert("ID 입력 부탁드려어요!");
      return;
    }
    else if(input_tag[1].value == ""){
      alert("PW 입력 부탁드려어요!");
      return;
    }
    var identity = {
      "id" : input_tag[0].value,
      "pw" : input_tag[1].value
    }
    var errorLogic = function(request,status,error){
      if(status != ERR_FAILED)
      {
        alert("잠시후 다시 해주세요");
      }
      else if(json.error == "ID"){
        alert("ID를 확인해주세요");
      }
      else if(json.error == "PW"){
        alert("PW를 확인해주세요");
      }
    }
    $.ajax({
      type :"post",
      url : "/login",
      data : identity,
      error: errorLogic
    });

}
