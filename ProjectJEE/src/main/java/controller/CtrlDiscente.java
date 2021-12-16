package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DiscenteService;

@WebServlet({"/CtrlDiscente"})

public class CtrlDiscente extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	public CtrlDiscente() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(" Get ");
		//DiscenteService.listaDiscenti();
		DiscenteService.insertDiscente();
		//DiscenteService.deleteDiscente();
		//DiscenteService.updateDiscente();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(" Post ");
		//DiscenteService.listaDiscenti();
		DiscenteService.insertDiscente();
		//DiscenteService.deleteDiscente();
		//DiscenteService.updateDiscente();
	}
	
	//bean.creoDiscente(11, "Mario", "Lombardo", 322);

}
