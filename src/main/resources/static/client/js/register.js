define(['jquery','common'],function(jquery,common){
	//用户名是否有效
	var isUserNameValidate = false;
	//密码是否为空
	var isUserPwdValidate = false;
	//用户确认密码是否为空
	var isUserRePwdValidate = false;
	//用户输入密码是否有效
	var isPwdValidate = false;
	//用户电子邮箱是否有效
	var isEmailValidate = false;
	//用户手机号是否有效
	var isPhoneValidate = false;

	//1.当用户名文本失去光标开始验证
	$("#username").blur(function(){
		isUserNameValidate = checkUserName("username");
	});
	//验证用户名
	function checkUserName(objId){
		//创建对象获取输入框内容
		var userName = $("#"+objId).val();
		$("#usernameError").css({display:"none"});
		//验证用户名是否为空
		if(userName == ""){
			$("#usernameError").html("请输入用户名！");
			$("#usernameError").css({display:"block"});
			return false;
		}
		//验证用户名长度是否错误
		if(userName.length<3 || userName.length>16){
			$("#usernameError").html("用户名长度错误！");
			$("#usernameError").css({display:"block"});
			return false;
		}
		//用户名内容是否规范
		var reg =/^[0-9a-zA-Z]+$/;
		var str = document.getElementById("username").value;
		if(!reg.test(str)){
			$("#usernameError").html("用户名只能为数字和英文！");
			$("#usernameError").css({display:"block"});
			return false;
		}
		//请求服务器验证用户名是否存在 同步
		var flag =true;
		$.ajax({
			url:baseUrl+"user/getuserbyaccount",
			type:"post",
			data:{info:userName,type:"account"},
			async:false,
			success:function(rs){
				//判断是否成功
				console.log(rs);
				if(rs.status==0){
					//账户已存在，显示错误
					$("#usernameError").css({dispaly:"block"});
					//错误信息添加
					$("#usernameError").html("用户已存在");
				}else{
					//隐藏错误信息
					$("#usernameError").css({dispaly:"none"});
					flag=true;
				}
			}
		});
		return flag;
	}
	
	//2.密码是否为空
	$("#password").blur(function(){
		isUserPwdValidate = checkUserPwd("password");
		//如果确认密码已经校验，则需要校验两者是否相同
		if(isUserRePwdValidate){
			isPwdValidate = checkPwdAndRePwd("password","rePassword");
		}
	});
	
	//检查密码是否为空
	function checkUserPwd(objId){
		//创建对象获取输入框内容
		var pwd = $("#"+objId).val();
		$("#userpasswordError").css({display:"none"});
		//校验密码是否为空
		if(pwd ==""){
			$("#userpasswordError").html("请输入密码！");
			$("#userpasswordError").css({display:"block"});
			return false;
		}
		//验证密码长度
		if(pwd.length<6 || pwd.length>12){
			$("#userpasswordError").html("密码长度为6-12位！");
			$("#userpasswordError").css({display:"block"});
			return false;
		}
		//验证密码格式
		var reg = /^[0-9a-zA-Z]+$/;
		var str = document.getElementById("password").value;
		if(!reg.test(str)){
			$("#userpasswordError").html("密码只能为数字和英文！");
			$("#userpasswordError").css({display:"block"});
			return false;
		}
		return true;
	}
	//3.确认密码是否为空   验证两次密码是够一致
	$("#rePassword").blur(function(){
		isUserRePwdValidate = checkReUserPwd("rePassword");
		if(isUserPwdValidate && isUserRePwdValidate){
			isPwdValidate = checkPwdAndRePwd("password","rePassword");
		}
	});
	
	//校验确认密码是否为空
	function checkReUserPwd(reObjId){
		//创建对象获取输入框内容
		var rePwd = $("#"+reObjId).val();
		$("#userpasswordError").css({display:"none"});
		if(rePwd == ""){
			$("#repasswordError").css({display:"block"});
			return false;
		}
		return true;
	}
	
	//校验密码和确认密码是否一致
	function checkPwdAndRePwd(objId,reObjId){
		//创建对象获取输入框内容
		var pwd = $("#"+objId).val();
		var rePwd = $("#"+reObjId).val();
		$("#repasswordError").css({display:"none"});
		if(!(pwd===rePwd)){
			$("#repasswordError").css({display:"block"});
			$("#repasswordError").html("两次密码不一致！");
			return false;
		}
		return true;
	}
	
	//5.当电子邮箱输入框失去光标
	$("#email").blur(function(){
		isEmailValidate = checkEmail("email");
	});
	
	//校验电子邮箱 是否为空 格式是否正确
	function checkEmail(objId){
		//创建对象获取输入框内容
		var email = $("#"+objId).val();
		$("#emailError").css({display:"none"});
		if(email == ""){
			$("#emailError").css({display:"block"});
			$("#emailError").html("请输入电子邮箱！");
			return false;
		}
		var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
		var obj = document.getElementById("email").value;
		if(!reg.test(obj)){
			$("#emailError").css({display:"block"});
			$("#emailError").html("邮箱格式错误！");
			return false;
		}
		return true;
	}

	//8.点击注册
	function registBtn(){
		//创建注册单击事件
		$("#register_btn").click(function(){
			//提交注册前检查校验结果
			if(!isUserNameValidate){
				return checkUserName("username");
			}
			if(!isUserPwdValidate){
				return checkUserPwd("password");
				
			}
			if(!isUserRePwdValidate){
				return checkReUserPwd("rePassword");
			}
			if(!isPwdValidate){
				return checkPwdAndRePwd("password","rePassword");
			}
			if(!isEmailValidate){
				return checkEmail("email");
			}
			//提交表单
			var formData={	account:$("#username").val(),
							password:$("#password").val(),
							email:$("#email").val(),
						};
			//请求服务器
			$.ajax({
				url:baseUrl+"user/do_register",
				type:"post",
				data:formData,
				success:function(rs){

					//判断方法是否成功
					if(rs.status==0){
						//注册成功跳转登录页面
						alert("注册成功");
						$(window).attr("location","signin.html");
					}else{
						//失败弹出提示
						alert(rs.msg);
					}
				},
			error:function(rs){
				alert("error");
			}
			});
		});
	}
	
	return {
		registBtn:registBtn
	};
});