package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/CtrlMain")
public class CtrlMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CtrlMain() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		visualizzaMenu(request, response);
	}

	private void visualizzaMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext oContesto = getServletContext();
		RequestDispatcher oDispatcher = oContesto.getRequestDispatcher("/Main/Main.jsp");
		oDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String controller = "";
		String valoreScelto = req.getParameter("formOk");
		if(valoreScelto != null)
		{
			String scelta = valoreScelto;
			switch(scelta) {
//			case "listaDocenti":
//				controller = "/CtrlDocente";
//				break;
			case "insertDocenti":
				controller = "/CtrlDocente";
				break;
//			case "deleteDocenti":
//				controller = "/CtrlDocente";
//				break;
//			case "updateDocenti":
//				controller = "/CtrlDocente";
//				break;
//			case "ListaDiscenti":
//				controller = "/CtrlDiscente";
//				break;
//			case "insertDiscenti":
//				controller = "/CtrlDiscente";
//				break;
//			case "deleteDiscenti":
//				controller = "/CtrlDiscente";
//				break;
//			case "updateDiscenti":
//				controller = "/CtrlDiscente";
//				break;

			default:
				visualizzaMenu(req, resp);
				break;
			}
			getServletContext().getRequestDispatcher(controller).forward(req, resp);
		}
		else {
			visualizzaMenu(req, resp);
		}
	}
}