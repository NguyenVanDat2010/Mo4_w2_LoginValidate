package demo.service.user;

import demo.model.User;
import demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;


    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(User model) {
        userRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        userRepository.delete(id);
    }
}
