package NHCBDP.webModule.Services;

import NHCBDP.webModule.Dao.UserDao;
import NHCBDP.webModule.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wbliu
 * @create 2017-09-04 16:07
 **/

@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;


    @Override
    public String isLogin(User user) {
        return userDao.selectByUserNameAndPassword(user) != null?"成功":"失败";
    }

    @Override
    public String isRegister(User user) {

        if (userDao.selectByUserNameAndPassword(user)!=null)
            return "用户已存在";

        return userDao.insert(user) == 1 ?"成功":"失败";
    }

}
