<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>

<script>
	function del(){
		confirm("确认删除？");
	}

</script>



</head>
<body>
	
	<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：教务中心-》班级管理</span> <span
			style="float: right; margin-right: 8px; font-weight: lighter">
            <a style="text-decoration: blink" href="javascript:alert('操作成功！');">【导出excel】&nbsp;&nbsp;</a>
            <a style="text-decoration: blink" href="selectdepts">【新增班级】&emsp;&emsp;&emsp;&emsp;</a>
		</span>
		</span>
	</div>

	<div class="cztable">
		<div>
			
			<ul class="seachform1">
				<form action="/Educational/class/selectallcla" method="post">
					<li>
						<label>班级名称:</label>
						<input name="classesname" type="text" class="scinput1" value="${cla}"/>&nbsp;&nbsp;
						<input  type="submit" class="scbtn" value="查询"/>&nbsp;
					</li>
						
				</form>

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tbody><tr style="font-weight: bold;">
                		<th  width="8%">
						<input type="checkbox"/>
						</th>
                        <th >院系</th>
						<th width="">班级编号</th>
						<th width="">班级名称</th>
                        <th width="15%">班主任老师</th>						
                        <th width="15%">人数</th>
						<th width="15%">班级状态</th>
						<th width="20%">操作</th>  
                    </tr>
				<c:forEach items="${pageInfo.list}" var="cla">
                    <tr id="product1">
                    	<td  width="8%" align="center">
						<input type="checkbox"/>
						</td>
                        <td align="center">${cla.department.departname}</td>
						<td align="center">${cla.classnum}</td>
                        <td align="center">${cla.classname}</td>
						<td align="center">${cla.classteacher}</td>
                        <td align="center">${cla.peoplecount}</td>
						<td align="center">${cla.classstate}</td>
						<td align="center">
                        	<a href="info.html">详情</a>
                            <c:if test="${cla.classstate=='未审核'||cla.classstate=='审核未通过'}">
                                <a href="edit.html">修改</a>
                                <a href="submitaudit?classid=${cla.classid}">提交审核</a>
                            </c:if>
                            <c:if test="${cla.classstate=='未审核'||cla.classstate=='审核未通过'||cla.classstate=='已毕业'}">
                                <a href="javascript:void(0)" onclick="del();return false" class="tablelink"> 删除</a>
                            </c:if>
						</td>
                    </tr>
				</c:forEach>

                <c:if test="${pageInfo.total!=0}">
                    <tr>
                        <td colspan="20" style="text-align: center;">						
						<a style="text-decoration: none;" href="#">
                            <a href="/Educational/class/selectallcla?classesname=${cla}"> 首页 </a>
                            <a href="/Educational/class/selectallcla?index=${pageInfo.prePage==0?1:pageInfo.prePage}">上一页</a>
                            <c:forEach begin="1" end="${pageInfo.pages}" var="i">
                                <a href="/Educational/class/selectallcla?index=${i}&classname=${cla}">${i}</a>
                            </c:forEach>

                            <a href="/Educational/class/selectallcla?index=${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage}&classname=${cla}">	下一页</a>
                            <a href="/Educational/class/selectallcla?index=${pageInfo.pages}&classname=${cla}">尾页</a>
                            共${pageInfo.total}条
                            每页显示 ${pageInfo.pageNum}/${pageInfo.pages} </a>
                        </td>
                    </tr>
                </c:if>
                <c:if test="${pageInfo.total==0}">
                    <tr>
                        <td colspan="20" style="text-align: center;">
                            未找到符合条件的数据
                        </td>
                    </tr>
                </c:if>
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
