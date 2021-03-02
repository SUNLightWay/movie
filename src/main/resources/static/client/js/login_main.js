require.config({
	 paths: {
			 "jquery": "jquery-3.5.1.min",
			 },
 });


require(['jquery','common','login'],function (jquery,common, login){
	$(function(){
		//1.失去光标时验证用户名
		login.accountCheck();
		//2.失去光标时验证密码
		login.pwdCheck();
		//登录
		login.loginBtn();
	});	
});