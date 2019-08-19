
function menu_list(){
    $.ajax({
        url :'/menu/list',
        async :false,
        type :'get',
        success:function(json){
            $.each(json,function(key,value){
                var append_item = $("<span></span>").text(value);
                $('.item').append(append_item);
            })
        },
        error : function(json){
    
        },
        complete : function(json){
    
        }
    });
}
$('document').ready(menu_list);

function test(){
    json = {"menu" :[{"menu_num":"1","menu_name":"test"},{"menu_num":'2',"menu_name":"test2"}]};
    $.each(json,function(key,value){
        alert(key+value);
        $.each(value,function(key,value){
            alert(key+value);
        });
    });
}
