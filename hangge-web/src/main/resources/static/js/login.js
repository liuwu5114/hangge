$("#signUp").click(function(){
    $("#container").addClass("right-panel-active");
})

$("#signIn").click(function(){
    $("#container").removeClass("right-panel-active");
})

$("#btn_login").click(function(){
    var mobile = $("#mobile").val();
    var possWord = $("#passWord").val();
    if(mobile == null && '' == mobile){
        alert("用户名不能为空")
    }
    if(possWord == null && '' == possWord){
        alert("密码不能为空")
    }
    $("#loginForm").submit();
});