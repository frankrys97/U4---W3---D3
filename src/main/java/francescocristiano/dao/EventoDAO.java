package francescocristiano.dao;

import francescocristiano.entities.Evento;
import francescocristiano.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento salvato correttamente");
    }

    public Evento getById(long id) {
        Evento eventoTrovato = em.find(Evento.class, id);
        if (eventoTrovato == null) throw new NotFoundException(id);

        return eventoTrovato;
    }

    public void findAndDeleteById(long id) {
        Evento eventoTrovato = getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(eventoTrovato);
        transaction.commit();
        System.out.println("Evento con id " + id + " eliminato correttamente");
    }
}
