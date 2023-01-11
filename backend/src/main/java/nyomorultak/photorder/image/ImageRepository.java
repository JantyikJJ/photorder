package nyomorultak.photorder.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query("SELECT i FROM Image i WHERE i.userId = ?1")
    Collection<Image> findImagesByUserId(int id);
}
