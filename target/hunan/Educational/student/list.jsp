<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息管理平台</title>
<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
<link href="../../css/mine.css" type="text/css" rel="stylesheet">
<script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="../../Script/jBox/jquery.jBox-2.3.min.js"
	type="text/javascript"></script>
<script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js"
	type="text/javascript"></script>
<script src="../../Script/Common.js" type="text/javascript"></script>
<script src="../../Script/Data.js" type="text/javascript"></script>

<script>
	function del(sid){
		var rs=confirm("确认退学？");
		alert(sid);
		if(rs==true){
			location.href="/Educational/student/updatestate?studentid="+sid;
		}
	}



	/*function del(sid){
		var rs=confirm("确认退学？");
		if(rs==true){
			location.href="/Educational/student/updatestate?studentid="+sid;
		}
	}*/



</script>



</head>
<body>
	
	<div class="div_head" style="width: 100%;text-align:center;">
		<span>
                <span style="float: left;">当前位置是：教务中心-》学生管理</span>
                <span style="float: right; margin-right: 8px; font-weight: bold;">
                    <a style="text-decoration: none;" href="/Educational/student/selectdepts">【新增学生】</a>&emsp;&emsp;&emsp;&emsp;
                </span>
            </span>
	</div>

	<div class="cztable">
		<div>
				  <form action="/Educational/student/selectall" method="post">
                    学生名称: 
					<input type="text" name="stuname" value="${sname}" />
                     学生学号: 
					<input type="text" name="stuno" value="${sno}" />
					性别: 
					<select name="stusex">
							<option value="-1">--请选择--</option>
							<option value="1" ${ssex==1?'selected':''}>男</option>
							<option value="0" ${ssex==0?'selected':''}>女</option>
						</select>
					<input type="submit" value="查询" />

                </form>



		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr style="height: 25px" align="center">
                        <th >学号</th>
						<th width="">姓名</th>
						<th width="">性别</th>
                        <th width="15%">联系电话</th>						
                        <th width="15%">专业</th>
						<th width="15%">登记时间</th>
						<th>操作</th>
                    </tr>

				<c:forEach items="${pi.list}" var="stu">
                    <tr id="product1">
                        <td align="center">${stu.studentno}</td>
						<td align="center">${stu.stuname}</td>
						<td align="center">${stu.stusex==1?'男':'女'}</td>
                        <td align="center">${stu.phone}</td>
						<td align="center">${stu.major.majorname}</td>
                        <td align="center"><fmt:formatDate value="${stu.regdate}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
						<td align="center">
							<a href="add.jsp">修改</a>
							<c:if test="${stu.stustate=='正常'}">
							<a href="javascript:void(0)" onclick="del(${stu.studentid});return false" class="tablelink"> 退学</a>
							</c:if>
							<a href="view.html">详细</a>
							<select>
								<option>退学</option>
								<option>休学</option>
							</select>
						</td> 				                    
                    </tr>
				</c:forEach>

				<c:if test="${pi.total!=0}">
                    <tr>
                        <td colspan="20" style="text-align: center;">						
						<a style="text-decoration: none;" href="#">
                            <a href="/Educational/student/selectall&stuname=${sname}&stuno=${sno}&stusex=${ssex}"> 首页 </a>
							<a href="/Educational/student/selectall?index=${pi.prePage==0?1:pi.prePage}&stuname=${sname}&stuno=${sno}&stusex=${ssex}">上一页</a>
							<c:forEach begin="1" end="${pi.pages}" var="i">
							<a href="/Educational/student/selectall?index=${i}&stuname=${sname}&stuno=${sno}&stusex=${ssex}">${i}</a>
							</c:forEach>

							<a href="/Educational/student/selectall?index=${pi.nextPage==0?pi.pages:pi.nextPage}&stuname=${sname}&stuno=${sno}&stusex=${ssex}">	下一页</a>
							<a href="/Educational/student/selectall?index=${pi.pages}&stuname=${sname}&stuno=${sno}&stusex=${ssex}">尾页</a>
							共${pi.total}条
							每页显示 ${pi.pageNum}/${pi.pages} </a>
                        </td>
                    </tr>
				</c:if>
                <c:if test="${pi.total==0}">
					<tr>
						<td colspan="20" style="text-align: center;">
							未找到符合条件的数据
						</td>
					</tr>
				</c:if>

	</tbody>
            </table>
	</div>

	</div>
	</div>

	</div>
</body>
</html>
