package NHCBDP.webModule.Dao;

import NHCBDP.webModule.Domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbliu
 * @create 2017-09-04 17:02
 **/


public interface UserDao {
    User selectByUserNameAndPassword(User user);


    //@Transactional(readOnly = true)
    List<User> findAll();

    //@Transactional(readOnly = true)
    User findUserById(int id);


    @Transactional
    int insert(User user);

    @Transactional
    void delete(Integer id);

    @Transactional
    void update(User user);
}
