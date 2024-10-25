package ejb;

import entity.CD;
import entity.Loan;

import jakarta.ejb.Stateful;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class AdminBean implements AdminService {

    @PersistenceContext
    private EntityManager entityManager;

    // Add a new CD
    public void addCD(String title, String artist, String genre) {
        CD cd = new CD(title, artist, genre);
        entityManager.persist(cd);
    }

    // Edit an existing CD
    public void updateCD(Long cdId, String title, String artist, String genre, boolean isBorrowed) {
        CD cd = entityManager.find(CD.class, cdId);
        if (cd != null) {
            cd.setTitle(title);
            cd.setArtist(artist);
            cd.setGenre(genre);
            cd.setBorrowed(isBorrowed);
        }
    }

    // Delete a CD
    public void deleteCD(Long cdId) {
        CD cd = entityManager.find(CD.class, cdId);
        if (cd != null) {
            entityManager.remove(cd);
        }
    }

    // View all loan records
    public List<Loan> viewAllLoans() {
        return entityManager.createQuery("SELECT l FROM Loan l", Loan.class).getResultList();
    }
}
