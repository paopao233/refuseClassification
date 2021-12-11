$(function(){
    hint1();//页面加载时加载
})
function hint1(){
    var message1=$("#msg1").val();//获取id为msg1隐藏域的value值
    var messageCode1=$("#msgCode1").val();//获取Id为msgCode1隐藏域的value值
    if (message1 != undefined && messageCode1 != undefined){
        if (message1 != "" && messageCode1 != ""){
            if (message1!=""||message1!=null){
                msg(message1,messageCode1);
                console.log(message1);
                console.log(messageCode1);
            }
        }
    }

}

function msg(mge,messageCode){

    if (messageCode == "200") {
        Swal.fire({
            icon: "info",
            title: "温馨的系统提示",
            text: mge,
            showConfirmButton: false,
            timerProgressBar: true,
            timer: 1500
        });
    } else {
        Swal.fire({
            icon: "info",
            title: "温馨的系统提示",
            text: mge,
            showConfirmButton: false,
            timerProgressBar: true,
            timer: 20000
        });
    }
}
