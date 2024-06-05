package francescocristiano;

import francescocristiano.dao.EventoDAO;
import francescocristiano.dao.LocationDAO;
import francescocristiano.dao.PartecipazioneDAO;
import francescocristiano.dao.PersonaDAO;
import francescocristiano.entities.Evento;
import francescocristiano.entities.Location;
import francescocristiano.entities.Partecipazione;
import francescocristiano.entities.Persona;
import francescocristiano.enums.Sesso;
import francescocristiano.enums.Stato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Date;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d3");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        LocationDAO ld = new LocationDAO(em);
        PersonaDAO pd = new PersonaDAO(em);
        PartecipazioneDAO pard = new PartecipazioneDAO(em);
        EventoDAO ed = new EventoDAO(em);

        Location location1 = new Location("Mole", "Torino");
        Location location2 = new Location("San Siro", "Milano");
        Location location3 = new Location("Stadio Olimpico", "Roma");


  /*      ld.save(location1);
        ld.save(location2);
        ld.save(location3);*/

        Persona persona1 = new Persona("Francesco", "Cristiano", "francescocristiano@example.com", LocalDate.of(1997, 5, 27), Sesso.M);
        Persona persona2 = new Persona("Antonio", "Rossi", "antoniorossi@example.com", LocalDate.of(2000, 7, 20), Sesso.M);
        Persona persona3 = new Persona("Maria", "Verdi", "mariaverdi@example.com", LocalDate.of(2001, 9, 15), Sesso.F);


    /*    pd.save(persona1);
        pd.save(persona2);
        pd.save(persona3);*/

        Persona persona1FromDb = pd.getById("d5f6d055-f9a3-4472-807a-f6cbb26e333f"); // Antonio Rossi
        Persona persona2FromDb = pd.getById("c191e10b-30b0-49bd-9f2d-16f26984540a"); // Francesco Cristiano
        Persona persona3FromDb = pd.getById("2ae5b583-7286-4745-87ab-e57d63a25ef2"); // Maria Verdi


        System.out.println(persona1FromDb);
        System.out.println(persona2FromDb);
        System.out.println(persona3FromDb);

        Location location1FromDb = ld.getById("50295b60-9299-48ce-ad48-ece9fa4db926"); // Torino
        Location location2FromDb = ld.getById("c81d4ae2-b9bb-4ddd-866c-25a537c5ab5d"); // Milano
        Location location3FromDb = ld.getById("0d63f149-0f45-4102-8658-8753ee92e28d"); // Roma


        System.out.println(location1FromDb);
        System.out.println(location2FromDb);
        System.out.println(location3FromDb);

        Evento evento1 = new Evento("Evento1", new Date(), "Descrizione1", francescocristiano.enums.TipoEvento.PUBBLICO, 10, location1FromDb);
        Evento evento2 = new Evento("Evento2", new Date(), "Descrizione2", francescocristiano.enums.TipoEvento.PUBBLICO, 20, location2FromDb);
        Evento evento3 = new Evento("Evento3", new Date(), "Descrizione3", francescocristiano.enums.TipoEvento.PRIVATO, 30, location3FromDb);


    /*    ed.save(evento1);
        ed.save(evento2);
        ed.save(evento3);*/

        Evento evento1FromDb = ed.getById(52);
        Evento evento2FromDb = ed.getById(53);
        Evento evento3FromDb = ed.getById(54);

        System.out.println(evento1FromDb);
        System.out.println(evento2FromDb);
        System.out.println(evento3FromDb);

        Partecipazione partecipazione1 = new Partecipazione(persona1FromDb, evento1FromDb, Stato.CONFERMATO);
        Partecipazione partecipazione2 = new Partecipazione(persona2FromDb, evento2FromDb, Stato.DA_CONFERMARE);
        Partecipazione partecipazione3 = new Partecipazione(persona3FromDb, evento3FromDb, Stato.CONFERMATO);


 /*       pard.save(partecipazione1);
        pard.save(partecipazione2);
        pard.save(partecipazione3);*/


    }
}
