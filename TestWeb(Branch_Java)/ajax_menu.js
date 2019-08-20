
function button_click(){
$.ajax({
    url: "http://localhost:8080/menu/list",
    method : "Get",
    dataType : "json",
    success: function(data){
        for(var object in data){
            $.each(object,function(key,value){
                alert(key+value);
            })
        }
    },
    error: function(e)
    {
        alert(e);
    }
})

}

