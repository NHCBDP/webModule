package NHCBDP.webModule.Controllers;

import NHCBDP.webModule.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wbliu
 * @create 2017-09-05 15:26
 **/

@RestController
@RequestMapping("business")
public class BusinessController {

    @Autowired
    UserService userService;

    @RequestMapping("/dataSourceStruct/{tableName}")
    public Object getDataSource(@PathVariable("tableName")String tableName){


      return userService.getDataSourceByTableName(tableName);
    }

}
