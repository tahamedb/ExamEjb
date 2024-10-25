package ejb;

import entity.CD;
import entity.Loan;
import jakarta.ejb.Remote;

import java.util.List;


@Remote
public interface AdminService {
    void addCD(String title, String artist, String genre);
    void updateCD(Long cdId, String title, String artist, String genre, boolean isBorrowed);
    void deleteCD(Long cdId);
    List<Loan> viewAllLoans();
}
