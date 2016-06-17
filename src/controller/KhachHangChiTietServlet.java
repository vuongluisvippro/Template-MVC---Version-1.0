package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.ObjectxBO;

/**
 * Servlet implementation class KhachTiemChiTietServlet
 */
@WebServlet("/admin/chi-tiet-lich-su-tiem-chung")
public class KhachHangChiTietServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangChiTietServlet() {
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
		if(request.getParameter("id")!=null){
			String maKH = request.getParameter("id");
			request.setAttribute("listObjx", new ObjectxBO().getItems(maKH));
			RequestDispatcher rd = request.getRequestDispatcher("/admin/khach-hang-chi-tiet.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/danh-sach-khach-hang");
		}
	}
}
