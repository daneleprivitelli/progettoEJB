package Beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.session.Discente;
import model.session.Docente;
import service.DiscenteService;
import service.DocenteService;

/**
 * Session Bean implementation class SessionBean
 */
@Stateless
@LocalBean
public class SessionBean implements SessionBeanRemote, SessionBeanLocal {

    /**
     * Default constructor. 
     */
    public SessionBean() {
        
    }
    
    public Docente creoDocente(Integer iddocente, String nome, String cognome, Integer punteggio ) {
    	
    	Docente d = new Docente();
    	
    	d.setId(iddocente);
    	d.setNome(nome);
    	d.setCognome(cognome);
    	d.setPunteggio(punteggio);
    	
    	
    	//salva sul db
    	DocenteService.insertDocente();
    	System.out.println("Io sono" + d);
    	
    	return d;
    	
    	
    }
   
    
}
