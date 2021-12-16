package service;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.session.Docente;
import oracle.jdbc.OracleTypes;
import util.Connessione;

public class DocenteService {
	
	public static void listaDocenti() {
		Connessione conn=new Connessione();
		try {
			conn.apri();
			String proc= "{CALL SP_LISTADOCENTI(?)}";
			CallableStatement cs=conn.connetti.prepareCall(proc);
			cs.registerOutParameter("curs_docs", OracleTypes.CURSOR);
			cs.execute();
			ResultSet results = (ResultSet)cs.getObject("curs_docs");		
			
			List<Docente> docenti= new ArrayList<Docente>();
			
			while(results.next()) {
				Docente d=new Docente();
				
				d.setId(results.getInt("IDDOCENTE"));
				d.setNome(results.getString("NOME"));
				d.setCognome(results.getString("COGNOME"));			
				d.setPunteggio(results.getInt("PUNTEGGIO"));
				
				System.out.println(d.getId()+ "   "+d.getNome()+"   "+d.getCognome()+ "   "+d.getPunteggio());
				
				docenti.add(d);
			}			
			conn.chiudi();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.chiudi();
		}
		
		
	}
	
	public static void insertDocente(Docente d) {
		Connessione conn=new Connessione();
		try {
			conn.apri();
			String proc= "{CALL INSERTDOCENTE(?,?,?,?)}";
			PreparedStatement cs=conn.connetti.prepareCall(proc);
			cs.setInt(1, d.getId());
			cs.setString(2, d.getNome());
			cs.setString(3, d.getCognome());
			cs.setInt(4, d.getPunteggio());
			cs.executeUpdate();			
			System.out.println("INSERT Done");
			conn.chiudi();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.chiudi();
		}	
	}
	
	
	public static void deleteDocente() {
		Connessione conn=new Connessione();
		try {
			conn.apri();
			String proc= "{CALL DELETEDOCENTE(?)}";
			PreparedStatement cs=conn.connetti.prepareCall(proc);
			cs.setInt(1, 1);
			cs.executeUpdate();			
			System.out.println("DELETE Done");
			conn.chiudi();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.chiudi();
		}	
	}
	
	public static void updateDocente() {
		Connessione conn=new Connessione();
		try {
			conn.apri();
			String proc= "{CALL UPDATEDOCENTE(?,?,?,?)}";
			PreparedStatement cs=conn.connetti.prepareCall(proc);
			cs.setInt(1, 5);
			cs.setString(2, "Pino");
			cs.setString(3, "Cacao");
			cs.setInt(4, 78);
			//cs.executeUpdate();	
			cs.execute();
			System.out.println("UPDATE Done");
			conn.chiudi();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.chiudi();
		}	
	}
	
	
	
}
