<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" /> 
        <script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
        <script language="javascript" type="text/javascript" >
			function check_login(){
				var patt = new RegExp(/^\w{3,30}$/);
				var admin_code = $("#admin_code").val();
				if(!patt.test(admin_code)){
					$("#admin_code_msg").text("3至30长度的字母、数字和下划线");
					return;
				}
				var password = $("#password").val();
				if(!patt.test(password)){
					$("#password_msg").text("3至30长度的字母、数字和下划线");
					return;
				}
				//验证验证码是否为空
				var code = $("#code").val();
				if(code == ""){
					$("#code_msg").text("请输入验证码");
					return;
				}
				$.post(
					"checkLogin.do",
					$("#myform").serialize(),
					function(data){
						if(data.flag == 1){
							$("#admin_code_msg").text("账号不存在");
						} else if(data.flag == 2){
							$("#password_msg").text("密码错误");
						}else if(data.flag == 3){
							$("#code_msg").text("验证码错误");
						} else {
							window.location.href="toIndex.do";
						}
						change();
					});
			}
			
			//光标切入文本框时，重置其提示信息
			function set_msg(txt_id){
				$("#"+txt_id).text("");
			}
			
			//刷新验证码图片
			function change(){
				$("#code_image").attr("src","createImage.do?date="+new Date().getTime());
			}
		</script>
    </head>
    <body class="index">
        <div class="login_box">
        <form id="myform"  >
            <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input id="admin_code" name="adminCode" type="text" class="width150" onfocus="set_msg('admin_code_msg')" /></td>
                    <td class="login_error_info"><span id="admin_code_msg" class="required"></span></td>
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input id="password" name="password" type="password" class="width150" onfocus="set_msg('password_msg')"/></td>
                    <td><span id="password_msg" class="required"></span></td>
                </tr>
                <tr>
                    <td class="login_info">验证码：</td>
                    <td class="width70"><input id="code" name="code" type="text" class="width70" onfocus="set_msg('code_msg')" /></td>
                    <td><img src="createImage.do" id="code_image" alt="验证码" title="点击更换" onclick="change()" /></td>  
                    <td><span id="code_msg" class="required"></span></td>              
                </tr>            
                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                        <a href="javaScript:check_login()"><img src="../images/login_btn.png" /></a>
                    </td>    
                  
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>
