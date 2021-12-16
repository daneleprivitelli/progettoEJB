package controller;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.SessionBean;
import service.DocenteService;

@WebServlet({"/CtrlDocente"})

public class CtrlDocente extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private SessionBean bean;

	
	public CtrlDocente() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(" Get ");
		//DocenteService.listaDocenti();
		//DocenteService.insertDocente();
		//DocenteService.deleteDocente();
		//DocenteService.updateDocente();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(" Post ");
		//DocenteService.listaDocenti();
		//DocenteService.insertDocente();
		//DocenteService.deleteDocente();
		//DocenteService.updateDocente();
		
		bean.creoDocente(11, "Beee", "Muu", 234);
		
	}
	
	
	
}

