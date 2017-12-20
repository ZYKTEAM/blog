$(document).ready(function() {
	
	/**
	 * 跳转登录页面
	 */
	$("#title-login").click(function(){
		window.location.href="/blog/signIn";
	}) 
	
	/**
	 * 注册
	 */
	$(".sig_up_zc").click(function(){
		var sign = {};
			sign.username = $("#username").val();					
			sign.phone = $("#phone").val();		
			sign.password = $("#password").val();
		if($("#username").val() == null || $("#username").val() == ""){
			layer.alert("账号不能为空!");
			return false;
		}
		if($("#phone").val() ==null || $("#phone").val() == ""){
			layer.alert("手机号不能为空!");
			return false;
		}
		if($("#password").val() == null || $("#password").val() == ""){
			layer.alert("密码不能为空!");
			return false;
		}
		$.ajax({
			type:"GET",
			url:"/blog/signupusername",
			data:{
				signInfo:JSON.stringify(sign)
			},
			success : function(data){
			  window.location.href="/blog/signIn";
			},error:function(data){
				layer.alert("出现错误信息!");
			}
		});

	})
});
