<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../Script/Common.js" type="text/javascript"></script>
    <script src="../Script/Data.js" type="text/javascript"></script>

    <script type="text/javascript">
        $(function(){
            $("[name='userName']").blur(function (){
                //1.先获得用户输入的值
                var str=$(this).val();
                str=$.trim(str);
                if(str.length>0){
                    if(str=='${sessionScope.user.userName}'){
                        alert("用户名未修改")
                    }else{
                        $(this).next().load("checkname","uname="+str);
                    }
                }else{
                    alert("请输入用户名");
                }
            })
        })
    </script>
    

</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：个人中心-》我的信息</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form action="updateuser" method="post">
        <input type="hidden" name="userId" value="${user.userId}"/>
	<table width="100%" cellpadding="0" cellspacing="0">
		<tr  width="120px;">
                    <td width="120px">用户名：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="userName" value="${user.userName}" />
                        <span></span>
					</td>
                </tr>

                <tr  width="120px;">
                    <td>姓名<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="userRealname" value="${user.userRealname}" />
					</td>
                </tr>
                <tr>
                    <td>性别<span style="color:red">*</span>：</td>
                    <td>
                        <input type="radio" name="userSex" ${user.userSex=='男'?'checked':' '} value="男" />男
                        <input type="radio" name="userSex" ${user.userSex=='女'?'checked':' '} value="女"/>女
                    </td>
                </tr>

				<tr>
                    <td>EMAIL：</td>
                    <td>
                        <input type="text" name="userEmail" value="${user.userEmail}" />
                    </td>                
                </tr>

				<tr>
                    <td>联系电话：</td>
                    <td>
                        <input type="text" name="userPhone" value="${user.userPhone}" />
                    </td>                
                </tr>

				<tr>
                    <td>住址：</td>
                    <td>
                        <input type="text" name="userAddress" value="${user.userAddress}" />
                    </td>                
                </tr>
				              
				<tr>
                    <td>身份证号：</td>
                    <td>
                        <input type="text" name="userIdcard" value="${user.userIdcard}" />
                    </td>                
                </tr>
				
				
				<tr>
                    <td>简介<span style="color:red">*</span>：</td>
                    <td>
                        <textarea name="userContent">${user.userContent}</textarea>
                    </td>
                </tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="保存">
			</td>
		</tr>
        
    </table>
	</form>
</div>

            </div>
        </div>
    </div>
</body>
</html>
