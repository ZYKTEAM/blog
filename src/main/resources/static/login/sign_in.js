$(document).ready(function() {
	
	/**
	 * 跳转注册页面
	 */
	$("#sign-up").click(function(){
		window.location.href="/blog/signUp";
	});
	
	/**
	 * 跳转找回密码页面
	 */
	$(".login-back").click(function(){
		window.location.href="/blog/signBack";
	});
	
	/**
	 * 跳转主页面
	 */
	$(".my_login").click(function(){
		window.location.href="/blog/index";
	});
	
	/**
	 * 登录
	 */
	$(".my_login").click(function(){
		var	 username = $("#sigin_iphone").val();					
		var	 password = $("#singin_password").val();
		if(username == null || username == ""){
			layer.alert("账号不能为空!");
			return false;
		}
		if(password == null || password == ""){
			layer.alert("密码不能为空!");
			return false;
		}
		$.ajax({
			type:"GET",
			url:"/blog/signinusername",
			data:{
				username:username,
				password:password
			},
			success : function(data){
			  window.location.href="/blog/index";
			},error:function(data){
				layer.alert("出现错误信息!");
			}
		});

	})
	
});
