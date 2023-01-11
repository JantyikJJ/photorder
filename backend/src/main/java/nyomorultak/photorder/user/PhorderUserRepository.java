package nyomorultak.photorder.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PhorderUserRepository extends JpaRepository<PhotorderUser, Integer> {
        @Query("SELECT u FROM PhotorderUser u WHERE u.name = ?1")
        Optional<PhotorderUser> findPhotorderUserByUsername(String username);
}