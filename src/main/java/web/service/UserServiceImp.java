package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.model.User;

import java.util.List;


@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void add(String name, String lastname, byte age) {
        userDao.add(name, lastname, age);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
