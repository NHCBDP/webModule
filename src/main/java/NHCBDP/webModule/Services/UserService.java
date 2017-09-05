package NHCBDP.webModule.Services;

import NHCBDP.webModule.Domain.User;

/**
 * @author wbliu
 * @create 2017-09-04 16:04
 **/


public interface  UserService {


    String isLogin(User user);

    String isRegister(User user);

    Object  getDataSourceByTableName(String tableName);
}
