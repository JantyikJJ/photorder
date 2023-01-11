package nyomorultak.photorder.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private final ImageRepository repository;

    @Autowired
    public ImageService(ImageRepository repository) {
        this.repository = repository;
    }

    public List<Image> getImages() {
        return repository.findAll();
    }
    public List<Image> getImages(int userId) {
        return repository.findAll();
    }
    public Image save(Image image) {
        return repository.save(image);
    }
}
