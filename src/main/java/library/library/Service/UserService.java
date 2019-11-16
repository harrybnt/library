package library.library.Service;

import library.library.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public String createUser(String userName){
        return userRepo.addUser(userName);
    }
}
