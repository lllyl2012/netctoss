<%@page pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
        <script language="javascript" type="text/javascript">
            //排序按钮的点击事件
            function sort(btnObj) {
                if (btnObj.className == "sort_desc")
                    btnObj.className = "sort_asc";
                else
                    btnObj.className = "sort_desc";
            }

            //启用
            function startFee(t) {
            	var status = t.value=='启用'?'0':'1';
                var r = window.confirm("确定要启用或暂停此资费吗？");
                if(r){
                	$.ajax({
                				"url":"updateStatus.do?page="+${costPage.page},
                				"data":{"status":status,"cost_id":t.title},
                				"datatype":"json",
                				"type":"get",
                				"success":function(json){
                					console.log(json)
                					if(json.state==1){
                						$("#cost_status"+t.title).text("开通");
                						$("#changeStatus"+t.title).val("暂停");
                						$("#starttime"+t.title).text(json.data);
                						console.log(json.data);
                				  }else{
                					  $("#cost_status"+t.title).text("暂停");
                					  $("#changeStatus"+t.title).val("启用");
                					                }
                								}
                					});
                               }
                       }
            //删除
            function deleteFee(id) {
                var r = window.confirm("确定要删除此资费吗？");
                if(r){
                	window.location.href="deleteCost.do?id="+id;
                                }
                document.getElementById("operate_result_info").style.display = "block";
            }
        </script>        
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <%@include file="../public/header.jsp" %>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="post">
                <!--排序-->
                <div class="search_add">
                    <div>
                        <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />-->
                        <input type="button" value="基费" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="时长" class="sort_asc" onclick="sort(this);" />
                    </div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='toAddCost.do';" />
                </div> 
                <!--启用操作的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>    
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th>资费ID</th>
                            <th class="width100">资费名称</th>
                            <th>基本时长</th>
                            <th>基本费用</th>
                            <th>单位费用</th>
                            <th>创建时间</th>
                            <th>开通时间</th>
                            <th class="width50">状态</th>
                            <th class="width200"></th>
                        </tr>  
                        <c:forEach items="${costs}" var="c">                    
                        <tr>
                            <td>${c.cost_id}</td>
                            <td><a href="fee_detail.html">${c.name}</a></td>
                            <td>${c.base_duration}小时</td>
                            <td>${c.base_cost}</td>
                            <td>${c.unit_cost}</td>
                            <td><fmt:formatDate value="${c.creatime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td id="starttime${c.cost_id}"><fmt:formatDate value="${c.startime}" pattern="yyyy-MM-dd"/></td>
                            <td id="cost_status${c.cost_id}">
                            	<c:choose>
                            		<c:when test="${c.status=='0'}">
                            			开通
                            		</c:when>
                            		<c:otherwise>暂停</c:otherwise>
                            	</c:choose>
                            </td>
                            <td>
                            	<c:choose>
                            		<c:when test="${c.status=='1'}">
                            			 <input type="button" id="changeStatus${c.cost_id}" title="${c.cost_id}" value="启用" class="btn_start" onclick="startFee(this);" />
                            		</c:when>                                
                                <c:otherwise>
                               		 <input type="button" id="changeStatus${c.cost_id}" title="${c.cost_id}" value="暂停" class="btn_start" onclick="startFee(this);" />
                                </c:otherwise>
                              </c:choose>
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateCost.do?id=${c.cost_id}';" />
                                <input type="button" value="删除" class="btn_delete" onclick="deleteFee(${c.cost_id});" />
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                    <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                    </p>
                </div>
                <!--分页-->
                <div id="pages">
                	<!-- 如果当前是第一页，不能点上一页 -->
                	<c:choose>
       	         	    	<c:when test="${costPage.page==1 }">
       	         	    		<a href="#">上一页</a>
       	         	    	</c:when>
       	         	    	<c:otherwise>
       	         	    		<a href="./findCost.do?page=${costPage.page-1 }">上一页</a>
       	         	    	</c:otherwise>    
     	         	</c:choose>
        	        <%--
        	        	使用items循环，相当于for(Cost c:costs){}
        	        	使用begin和end循环，相当于for(int i=1;i<totaPage;i++){}
        	         --%>
        	        <c:forEach begin="1" end="${costPage.totalPage }" var="p">
        	         	    <c:choose>
        	         	    	<c:when test="${p==costPage.page }">
        	         	    		<a href="./findCost.do?page=${p }" class="current_page">${p }</a>
        	         	    	</c:when>
        	         	    	<c:otherwise>
        	         	    		<a href="./findCost.do?page=${p }">${p }</a>
        	         	    	</c:otherwise>    
        	         	    </c:choose>
                    </c:forEach>
                    <!-- 如果当前页是最后一页，不能点下一页 -->
                    <c:choose>
       	         	    	<c:when test="${costPage.page==costPage.totalPage }">
       	         	    		<a href="#">下一页</a>
       	         	    	</c:when>
       	         	    	<c:otherwise>
       	         	    		<a href="./findCost.do?page=${costPage.page+1 }">下一页</a>
       	         	    	</c:otherwise>    
     	         	</c:choose>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)加拿大达内IT培训集团公司 </p>
        </div>
    </body>
</html>