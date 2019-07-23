<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加书籍</title>



<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("form").submit(function(){
		//验证信息
		var str=$("[name='cid']").val();
		if(str=='请选择'){
			alert('请选择分类');
			return false;
		}
		
		var title=$("[name='title']").val();
		if($.trim(title).length==0){
			alert("请填写标题");
			return false;
		}
		
		var content=$("[name='content']").val();
		if($.trim(content).length==0){
			alert("请填写内容");
			return false;
		}
		return true;
	})
})
	
</script>




</head>
<body>
<h1>添加新条目</h1>
<form action="knowledgeservlet" method="post">
  <input type="hidden" name="method" value="add">
	分类:<select name="cid">
			<option>请选择</option>
			<c:forEach items="${clist}" var="cl">
				<option value="${cl.id}">${cl.cname}</option>
			</c:forEach>
	    </select> <br/>
	标题:<input type="text" name="title"><br/>
	内容:<textarea rows="5" cols="20" name="content"></textarea><br>
	<input type="submit" value="保存">
	<input type="reset" value="重置">
	<input type="button" value="放弃">
</form>

</body>
</html>