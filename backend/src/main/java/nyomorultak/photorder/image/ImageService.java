package nyomorultak.photorder.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return repository.findImagesByUserId(userId).stream().toList();
    }
    public Image save(Image image) {
        return repository.save(image);
    }

    public Image updateImage(int imageId, int status) {
        Optional<Image> image = repository.findById(imageId);

        if (image.isEmpty()) return null;

        Image img = image.get();
        img.setStatus(status);

        return repository.save(img);
    }
}
