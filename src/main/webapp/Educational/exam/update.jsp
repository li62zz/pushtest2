<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../Script/Data.js" type="text/javascript"></script>
    
    <script type="text/javascript">
        function submitMail() {
            var mtitle = "联系方式有修改";
            var html = "<div style='padding:10px;'><div style='width:65px; height:120px; float:left;'>修改的地方：</div><div style='width:250px; height:120px; float:left;'><textarea id='objeCont' name='objeCont' style='width:250px; height:105px;'></textarea></div></div>";

            var submit = function (v, h, f) {
                if (f.objeCont == '' || f.objeCont.length > 80) {
                    $.jBox.tip("请您输入有修改的地方，且不超过80个字！", 'error', { focusId: "objeCont" }); // 关闭设置 objeCont 为焦点
                    return false;
                }

                StudentCompain.insertCompain('', mtitle, 5, f.objeCont, function (data) {
                    var obj = $.parseJSON(data);
                    var resultObj = false;
                    if (obj.ok) {
                        $.jBox.tip("成功提交联系方式的修改邮件！");
                    }
                });
            };

            $.jBox(html, { title: "联系方式修改的邮件", submit: submit });
        }
    </script>

    <script type="text/javascript">
        $(function () {
            //获得专业
            $("[name='deptid']").change(function () {
                var val=$(this).val();
                if(val==-1){
                    alert("请选择院系");
                }else {
                    $.getJSON("/Educational/exam/findallmajor","deptid="+val,function (rs) {
                        $("[name='majorid']")[0].length=0;
                        $("[name='classid']")[0].length=0;
                        $("[name='classid']")[0].add(new Option("--请选择--",null));
                        $("[name='majorid']")[0].add(new Option("--请选择--",-1));
                        for(var i=0;i<rs.length;i++){
                            $("[name='majorid']")[0].add(new Option(rs[i].majorname,rs[i].majorid));
                        }
                    })
                }
            })

            //获得班级
            $("[name='majorid']").change(function () {
                var val=$(this).val();
                if(val==-1){
                    alert("请选择专业");
                }else {
                    $.getJSON("findclassbyid","mid="+val,function (rs) {
                        $("[name='classid']")[0].length=0;
                        $("[name='classid']")[0].add(new Option("--请选择--",-1));
                        for(var i=0;i<rs.length;i++){
                            $("[name='classid']")[0].add(new Option(rs[i].classname,rs[i].classid))
                        }
                    })
                }
            })

        })

    </script>


</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：教务中心-》考试-》更新</span>
                <span style="float:right;margin-right: 8px;font-weight: bold">
                    <a style="text-decoration: none" href="exam.jsp">【返回】</a>
                </span>
            </span>
        </div>
</div>
<div class="cztable">
	<form action="updateexambyid" method="post">

    <table width="100%" cellpadding="0" cellspacing="0">
        <tr>
            <td align="right" width="80">编号：</td>
            <td>
				<input type="text"  name=examid value="${exam.examid}" />
			</td>
        </tr>
		
        <tr>
            <td align="right" >考试编号：</td>
            <td>
				<input type="text"  name="examnum" value="${exam.examnum}" />
			</td>
        </tr>


        <tr>
            <td align="right">考试科目：</td>
            <td>
				<input type="text" name="examsubject" value="${exam.examsubject}" />
			</td>
        </tr>

		<tr>
            <td align="right">考试时间：</td>
            <td>

				<input type="text" name="examtime" value="<fmt:formatDate value="${exam.examtime}" pattern="yyyy/MM/dd"></fmt:formatDate>"/>
			</td>
        </tr>

		<tr>
            <td align="right">考试班级：</td>
            <td>
				<select name="deptid" >
                    <c:forEach items="${deptlist}" var="dept">
                        <option value="${dept.departid}" ${dept.departid==exam.deptid?'selected':' '}>
                                ${dept.departname}
                        </option>
                    </c:forEach>

                </select>
                <select name="majorid" >
                    <c:forEach items="${majorlist}" var="mlist" >
                        	<option value="${mlist.majorid}" ${mlist.majorid==exam.majorid?'selected':''}>
                                    ${mlist.majorname}
                            </option>
                    </c:forEach>
                </select>
                <select name="classid">
                    <c:forEach items="${clalist}" var="clist" >
                        	<option value="${clist.classid}" ${clist.classid==exam.majorid?'selected':''}>
                                ${clist.classname}
                            </option>
                    </c:forEach>
       			</select>        
			</td>
        </tr>

		<tr>
            <td align="right">考试人数：</td>
            <td>
				<input type="text" name="examcount" value="${exam.examcount}"/>
			</td>
        </tr>

		<tr>
            <td align="right">考试状态：</td>
            <td>
				<input type="text" name="examstate" value="${exam.examstate}"/>
			</td>
        </tr>
        
        <tr align="center">
            <td colspan="5" height="40">
                <div align="center">
                    
                    <input type="submit" id="button2" value="更新"/>
                </div>
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
