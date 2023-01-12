package nyomorultak.photorder.image;

import nyomorultak.photorder.generic.PhotorderResponse;
import nyomorultak.photorder.image.requests.ImageUploadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/image")
public class ImageController {
    private final ImageService service;

    @Autowired
    public ImageController(ImageService service) {
        this.service = service;
    }

    @PostMapping("/")
    public PhotorderResponse<List<Image>> postImage(@RequestBody ImageUploadRequest request) {
        if (request.image.length() > 0) {
            String base64String = request.image;
            String[] strings = base64String.split(",");

            String extension = switch (strings[0]) {
                case "data:image/jpeg;base64" -> "jpeg";
                case "data:image/png;base64" -> "png";
                default -> "jpg";
            };

            byte[] data = Base64.getDecoder().decode(strings[1]);

            try {
                Files.createDirectories(Paths.get("public"));

                String fileName = new SimpleDateFormat("Img-ddMMyy-hhmmss.SSS." + extension).format(new Date());
                String path = "public/" + fileName;

                File file = new File(path);

                OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
                outputStream.write(data);
                outputStream.flush();
                outputStream.close();

                Image img = new Image(request.userId, "content/" + fileName,
                        0, request.printWidth, request.printHeight);

                return new PhotorderResponse<>(List.of(service.save(img)));
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        return new PhotorderResponse<>();
    }

    @GetMapping("/")
    public PhotorderResponse<List<Image>> getImages() {
        return new PhotorderResponse<>(service.getImages());
    }

    @GetMapping("/{userId}")
    public PhotorderResponse<List<Image>> getImagesByUserId(@PathVariable int userId) {
        return new PhotorderResponse<>(service.getImages(userId));
    }

    @PutMapping("/{imageId}/{status}")
    public PhotorderResponse<List<Image>> updateImageStatus(@PathVariable int imageId, @PathVariable int status) {
        Image img = service.updateImage(imageId, status);
        if (img == null)
            return new PhotorderResponse<>();
        else return new PhotorderResponse<>(List.of(img));
    }
}
