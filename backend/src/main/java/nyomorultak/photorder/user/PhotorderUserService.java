package nyomorultak.photorder.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotorderUserService {

    private final PhorderUserRepository repository;
    @Autowired
    public PhotorderUserService(PhorderUserRepository repository) {
        this.repository = repository;
    }

    public List<PhotorderUser> getUsers() {
        return repository.findAll();
    }

    public boolean usernameTaken( PhotorderUser user){
        Optional<PhotorderUser> dbUser = repository.findPhotorderUserByUsername(user.name);
        return dbUser.isPresent();
    }
    public PhotorderUser saveUser(PhotorderUser user){
        return repository.save(user);
    }

    public Optional<PhotorderUser> validateUser( PhotorderUser user){
        Optional<PhotorderUser> dbUser = repository.findPhotorderUserByUsername(user.name);
        if( dbUser.isPresent() && dbUser.get().password.equals(user.password)){
            return dbUser;
        }
        return Optional.empty();
    }
}