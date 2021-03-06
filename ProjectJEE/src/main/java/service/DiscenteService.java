package service;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.session.Discente;
import oracle.jdbc.OracleTypes;
import util.Connessione;

public class DiscenteService {
	
	public static void listaDiscenti() {
		Connessione conn=new Connessione();
		try {
			conn.apri();
			String proc= "{CALL SP_LISTADISCENTI(?)}";
			CallableStatement cs=conn.connetti.prepareCall(proc);
			cs.registerOutParameter("curs_docs", OracleTypes.CURSOR);
			cs.execute();
			ResultSet results = (ResultSet)cs.getObject("curs_docs");		
			
			List<Discente> discenti= new ArrayList<Discente>();
			
			while(results.next()) {
				Discente d=new Discente();
				
				d.setIddiscente(results.getInt("IDDISCENTE"));
				d.setNomediscente(results.getString("NOMEDISCENTE"));
				d.setCognomediscente(results.getString("COGNOMEDISCENTE"));			
				d.setMatricola(results.getInt("MATRICOLA"));
				
				System.out.println(d.getIddiscente()+ "   "+d.getNomediscente()+"   "+d.getCognomediscente()+ "   "+d.getMatricola());
				
				discenti.add(d);
			}			
			conn.chiudi();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.chiudi();
		}
		
		
	}
	
	public static void insertDiscente() {
		Connessione conn=new Connessione();
		try {
			conn.apri();
			String proc= "{CALL INSERTDISCENTE(?,?,?,?)}";
			PreparedStatement cs=conn.connetti.prepareCall(proc);
			cs.setInt(1, 5);
			cs.setString(2, "Pietro");
			cs.setString(3, "Insegno");
			cs.setInt(4, 1803);
			cs.executeUpdate();			
			System.out.println("INSERT Done");
			conn.chiudi();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.chiudi();
		}	
	}
	
	
	public static void deleteDiscente() {
		Connessione conn=new Connessione();
		try {
			conn.apri();
			String proc= "{CALL DELETEDISCENTE(?)}";
			PreparedStatement cs=conn.connetti.prepareCall(proc);
			cs.setInt(1, 5);
			cs.executeUpdate();			
			System.out.println("DELETE Done");
			conn.chiudi();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.chiudi();
		}	
	}
	
	public static void updateDiscente() {
		Connessione conn=new Connessione();
		try {
			conn.apri();
			String proc= "{CALL UPDATEDISCENTE(?,?,?,?)}";
			PreparedStatement cs=conn.connetti.prepareCall(proc);
			cs.setInt(1, 5);
			cs.setString(2, "Gianni");
			cs.setString(3, "Cacao");
			cs.setInt(4, 2031);
			cs.executeUpdate();			
			System.out.println("UPDATE Done");
			conn.chiudi();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			conn.chiudi();
		}	
	}

}
