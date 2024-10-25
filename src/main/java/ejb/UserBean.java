package ejb;


import entity.CD;
import entity.Loan;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Named
@SessionScoped
@Stateless
public class UserBean implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    // List all available CDs
    public List<CD> listAvailableCDs() {
        TypedQuery<CD> query = entityManager.createQuery("SELECT c FROM CD c WHERE c.isBorrowed = false", CD.class);
        return query.getResultList();
    }

    // Borrow a CD
    public boolean borrowCD(Long userId, Long cdId) {
        CD cd = entityManager.find(CD.class, cdId);
        if (cd != null && !cd.isBorrowed()) {
            cd.setBorrowed(true);
            Loan loan = new Loan(cd, userId, new Date());
            entityManager.persist(loan);
            return true;
        }
        return false;
    }

    // Return a CD
    public boolean returnCD(Long userId, Long cdId) {
        TypedQuery<Loan> query = entityManager.createQuery("SELECT l FROM Loan l WHERE l.cd.id = :cdId AND l.userId = :userId AND l.returnDate IS NULL", Loan.class);
        query.setParameter("cdId", cdId);
        query.setParameter("userId", userId);
        List<Loan> loans = query.getResultList();

        if (!loans.isEmpty()) {
            Loan loan = loans.get(0);
            loan.setReturnDate(new Date());
            CD cd = loan.getCd();
            cd.setBorrowed(false);
            return true;
        }
        return false;
    }
}
