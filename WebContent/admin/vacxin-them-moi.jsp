<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">

	<div class="module">
		 <h2><span style="font-size:18px">Thêm mới một loại vắc xin</span></h2>
		 <%
			 if(request.getAttribute("error") != null){
					String msg = (String)request.getAttribute("error");
					out.print(msg);
			 }
		 %>
		 <div class="module-body">
			<form action="<%=request.getContextPath()%>/admin/doVacxinThemMoi" method = "post" id="frmaddcacxin">
				<p>
					<label>Tên Vắcxin</label>
					<input type="text" name="tenVacxin" value="" class="input-medium"/>
				</p>
				<p>
					<label>Số mũi</label>
					<input type="number" name="soMui" value="" class="input-medium"/>
				</p>
				<p>
					<label>Mô tả</label>
					<textarea name="moTa" rows="7" cols="90" class="input-medium"></textarea>
				</p>
				<p>
					<label>Giá Vắcxin</label>
					<input type="number" name="giaVacxin" value="" class="input-medium"/>
				</p>
				<p>
					<label>Tên Hãng</label>
					<input type="text" name="tenHang" class="input-medium"/>
				</p>
				<fieldset>
					<input class="submit-green" name="them" type="submit" value="Thêm mới" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập lại" />
				</fieldset>
			</form>
			<script>
			$(document).ready(function(){
        		$('#frmaddcacxin').validate({
        			rules:{
        					tenVacxin:{
        						required:true,
        						minlength:2,
        						maxlength:12
        					},
        					soMui:{
        						required:true,
        						minlength:1,
        						maxlength:100
        					},
        					moTa:{
        						required:true,
        						minlength:1
        					},
        					giaVacxin:{
        						required:true,
        						minlength:1
        					},
        					tenHang:{
        						required:true,
        						minlength:1,
        						maxlength:255
        					}
        				},
        			messages:{
        					tenVacxin:{
        						required:"<p style = 'color:red'>Please do not blank field tên vắc xin !</p>"
        					},
        					soMui:{
        						required:"<p style = 'color:red'>Please do not blank field số mũi tiêm !</p>"
        					},
        					moTa:{
        						required:"<p style = 'color:red'>Please do not blank field mô tả !</p>"
        					},
							giaVacxin:{
								required:"<p style = 'color:red'>Please do not blank field giá vắc xin !</p>"
        					},
        					tenHang:{
        						required:"<p style = 'color:red'>Please do not blank field tên Hãng !</p>"
        					}
        			}
        		});
        	});	
			</script>
			<!--  Bắt validate trường rỗng -->
		 </div> <!-- End .module-body -->
	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 