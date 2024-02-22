package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.entities.User;

import java.util.List;

/**
 * @author Mukhammed Asantegin
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
            select u from User u 
            where u.firstName ilike (:keyword)
            or u.lastName ilike (:keyword)
            or u.email ilike (:keyword)            
            """)
    List<User> search(String keyword);
}
