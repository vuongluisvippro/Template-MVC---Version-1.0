package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Vacxin;
import model.bo.VacxinBO;
import utils.CheckVX;

/**
 * Servlet implementation class doVacxinCapNhat
 */
@WebServlet("/admin/doVacxinCapNhat")
public class doVacxinCapNhat extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doVacxinCapNhat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("capnhat")!=null){
				String maVacxin = request.getParameter("id");
				String tenVacxin = new String(request.getParameter("tenVacxin").toString().getBytes("ISO-8859-1"),"UTF-8");
				int soMui = Integer.parseInt(request.getParameter("soMui"));
				String moTa = new String(request.getParameter("moTa").toString().getBytes("ISO-8859-1"),"UTF-8");
				int giaVacxin = Integer.parseInt(request.getParameter("giaVacxin"));
				String tenHang = new String(request.getParameter("tenHang").toString().getBytes("ISO-8859-1"),"UTF-8");
				Vacxin vacxin = new Vacxin(maVacxin,tenVacxin,soMui,moTa,giaVacxin,tenHang);
				if(!new CheckVX().checkUpdateName(tenVacxin,maVacxin)){
					if(new VacxinBO().editVacxin(vacxin) > 0){
						response.sendRedirect(request.getContextPath()+"/admin/danh-sach-vacxin?msg=edit1");
					}else{
						response.sendRedirect(request.getContextPath()+"/admin/danh-sach-vacxin?msg=edit0");
					}
				}else{
					request.setAttribute("vacxin", new VacxinBO().getVacxin(maVacxin));
					request.setAttribute("error", "Tên vắc xin tồn tại trong hệ thống");
					RequestDispatcher rd = request.getRequestDispatcher("/admin/vacxin-cap-nhat");
					rd.forward(request, response);
				}
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/danh-sach-vacxin");
			}
	}
}
