package library.library.Service;

import library.library.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public String createUser(String userId , String userName){
        return userDao.save(userId,userName);
    }
}
