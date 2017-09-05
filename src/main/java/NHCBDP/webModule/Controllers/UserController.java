package NHCBDP.webModule.Controllers;

import NHCBDP.webModule.Domain.User;
import NHCBDP.webModule.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * @author wbliu
 * @create 2017-09-01 16:01
 **/


@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String  userLogin(@RequestBody User user) {
        return userService.isLogin(user);
    }


    @RequestMapping(value = "/register",method =RequestMethod.PUT)
    @ResponseBody
    public String  userRegister(@RequestBody User user) {
        return userService.isRegister(user);
    }




}