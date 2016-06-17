<%@page import="model.bean.Vacxin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		  <a href="<%=request.getContextPath()%>/admin/doVacxinThemMoi" class="button">
			<span>Thêm Vắcxin <img src="<%=request.getContextPath()%>/templates/admin/images/plus-small.gif" alt="Thêm Vắcxin"></span>
		  </a>
	  </div>
	  <div class="clear"></div>
</div>

<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách chi phí từng khách hàng tại trung tâm</span></h2>
		<div class="module-table-body">
			<form action="">
			<%
			%>
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:10%; text-align: center;">Tên Khách Hàng</th>
						<th style="width:20%">Chi phí</th>
					</tr>
				</thead>
				<tbody>
					<%
							%>
								<tr>
									<td class="align-center"><%%></td>
									<td class="align-center"><%%></td>
								</tr>
							<%
					%>
				</tbody>
			</table>
			</form>
		 </div> <!-- End .module-table-body -->
	</div> <!-- End .module -->
		 <div class="pagination">           
			<div class="numbers">
				<span>Trang:</span> 
				<a href="">1</a> 
				<span>|</span> 
				<a href="">2</a> 
				<span>|</span> 
				<span class="current">3</span> 
			</div> 
			<div style="clear: both;"></div> 
		 </div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 