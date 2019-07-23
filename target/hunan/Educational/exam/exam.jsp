<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	function del(){

	}

</script>



</head>
<body>
	
	<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：教务中心-》考试</span> <span
			style="float:right;margin-right: 8px;font-weight: bold"> <a
				style="text-decoration: none" href="findalldept">【新增考试】</a>
		</span>
		</span>
	</div>

	<div class="cztable">
		<div>
			
			<ul class="seachform1">
				<form action="/Educational/exam/findlist" method="post">
					<li>
						<label>考试科目</label>
						<input name="examsubject" type="text"  value="${examsubject}"/>&nbsp;&nbsp;
						<input  type="submit"  value="查询"/>&nbsp;
					</li>
						
				</form>

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tbody>
				<tr style="height: 25px" align="center">
					<th scope="col">编号</th>
					<th scope="col">考试编号</th>
					<th scope="col">考试科目</th>
					<th scope="col">考试时间</th>
					<th scope="col">考试班级</th>
					<th scope="col">考试状态</th>
					<th scope="col">操作</th>
				</tr>

				<c:forEach items="${pageInfo.list}" var="elist" varStatus="i">
					<tr align="center">
						<td>${i.count}</td>
						<td>${elist.examnum}</td>
						<td>${elist.examsubject}</td>
						<td><fmt:formatDate value="${elist.examtime}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
						<td>${elist.classes.classname}</td>
						<td>${elist.examstate}</td>
						<td>
						<c:if test="${elist.examstate=='已结束'}">
							<a href="findexam?examid=${elist.examid}">考试成绩</a>
							<a href="findbyeid?examid=${elist.examid}">组织补考</a>
						</c:if>
						<c:if test="${elist.examstate=='准备中'}">
							<a href="selectbyeid?examid=${elist.examid}">修改</a>
							<a href="deletebyid?examid=${elist.examid}" onclick="del();" class="tablelink"> 删除</a>
						</c:if>
							<a href="findbyid?examid=${elist.examid}">详细</a>
						</td>
					</tr>
				</c:forEach>
				 <tr>
                        <td colspan="20" style="text-align: center;">						
						<a style="text-decoration: none;" href="#">
                            <a href="/Educational/exam/findlist?examsubject=${examsubject}"> 首页 </a>
							<a href="/Educational/exam/findlist?examsubject=${examsubject}&index=${pageInfo.prePage==0?1:pageInfo.prePage}">上一页  </a>

							<c:forEach begin="1" end="${pageInfo.pages}" var="i">
							<a href="/Educational/exam/findlist?examsubject=${examsubject}&index=${i}">${i} </a>
							</c:forEach>

							<a href="/Educational/exam/findlist?examsubject=${examsubject}&index=${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage}">下一页 </a>
							<a href="/Educational/exam/findlist?examsubject=${examsubject}&index=${pageInfo.pages}">尾页 </a>
							共${pageInfo.total}条
							每页显示
							${pageInfo.pageNum}/${pageInfo.pages}
						</a>
                        </td>
                    </tr>
			</tbody>
		</table>
	</div>

	</div>
	</div>

	</div>
</body>
</html>
