package NHCBDP.webModule.Controllers;

import NHCBDP.webModule.Domain.RequestNote;
import NHCBDP.webModule.Domain.TableFieldBean;
import NHCBDP.webModule.Services.DataSourceService;
import NHCBDP.webModule.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wbliu
 * @create 2017-09-05 15:26
 **/

@RestController
@RequestMapping("/webModule/business")
public class BusinessController {

    @Autowired
    UserService userService;

    @Autowired
    DataSourceService dataSourceService;


    @RequestMapping(value = "/dataSourceTableDescribe/{tableName}",method = RequestMethod.GET)
    public Map<String,List<TableFieldBean>> getTableDescribe(@PathVariable("tableName")String tableName){
        List<TableFieldBean> tableFieldBeanList = dataSourceService.getTableDescribe(tableName);

        Map <String,List<TableFieldBean>> resMap = new HashMap<String, List<TableFieldBean>>();
        resMap.put(tableName,tableFieldBeanList);

        return resMap;
    }



    @RequestMapping(value = "/dataSourceDescribe/{dbName}",method = RequestMethod.GET)
    public Map<String,List<Map<String,List<TableFieldBean>>>> getAllTableDescribe(@PathVariable("dbName")String dbName){
          Map<String,List<Map<String,List<TableFieldBean>>>> resMap = new HashMap<String, List<Map<String, List<TableFieldBean>>>>();
          List<Map<String,List<TableFieldBean>>> tableList = dataSourceService.getAllTableDescribe(dbName);
          resMap.put(dbName,tableList);
         return resMap;
    }

    @RequestMapping(value = "/allDataSourceDescribe",method = RequestMethod.GET)
    public Map<String,List<Map<String,List<TableFieldBean>>>> getAllTableDescribe(){
        return dataSourceService.getAllTableDescribe();
    }


    @RequestMapping(value = "/commitRequestNote",method = RequestMethod.POST)
    public String  commitRequestNote(@RequestBody RequestNote requestNote){
        return dataSourceService.commitRequestNote(requestNote);
    }

    @RequestMapping(value = "/getRequestNote/{userName}",method = RequestMethod.GET)
    public List<RequestNote>  getRequestNote(@PathVariable("userName") String userName){
        return dataSourceService.getRequestNote(userName);
    }

    @RequestMapping(value = "/getRequestNoteByRequestNoteId/{requestNoteId}",method = RequestMethod.GET)
    public List<RequestNote>  getRequestNoteByRequestNoteId(@PathVariable("requestNoteId") String requestNoteId){
        return dataSourceService.getRequestNoteByRequsetNoteId(requestNoteId);
    }






}
