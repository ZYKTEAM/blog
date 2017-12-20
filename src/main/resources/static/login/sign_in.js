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
	
});
