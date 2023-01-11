package nyomorultak.photorder.user;

import nyomorultak.photorder.generic.PhotorderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/api/user")

public class PhotorderUserController {

    private final PhotorderUserService photorderUserService;
    @Autowired
    public PhotorderUserController(PhotorderUserService photorderUserService) {
        this.photorderUserService = photorderUserService;
    }

    @GetMapping("/")
    public PhotorderResponse<List<PhotorderUser>> getUser() {
        return new PhotorderResponse<>(photorderUserService.getUsers());
    }

    @PostMapping("/login")
    public PhotorderResponse<PhotorderUser> loginUser(@RequestBody PhotorderUser user){
        user.password = hashPassword(user.password);
        Optional<PhotorderUser> validUser = photorderUserService.validateUser(user);
        if (validUser.isPresent()){
            return new PhotorderResponse<>(validUser.get());
        }
        return new PhotorderResponse<>();
    }

    @PostMapping("/register")
    public PhotorderResponse<PhotorderUser> registerUser(@RequestBody PhotorderUser user){
        if (photorderUserService.usernameTaken(user) || user.password.length() < 8 || user.password.length() > 20 ){
            return new PhotorderResponse<>();
        }
        else {
            user.password = hashPassword(user.password);
            return new PhotorderResponse<>(photorderUserService.saveUser(user));
        }
    }


    private String hashPassword(String password) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] hash = sha.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }



}