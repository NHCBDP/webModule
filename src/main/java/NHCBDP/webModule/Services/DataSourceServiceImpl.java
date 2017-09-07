package NHCBDP.webModule.Services;

import NHCBDP.webModule.Dao.DataSourceDao;
import NHCBDP.webModule.Domain.DbTablesBean;
import NHCBDP.webModule.Domain.RequestNote;
import NHCBDP.webModule.Domain.TableFieldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author wbliu
 * @create 2017-09-05 16:35
 **/

@Transactional
@Service("dataSourceService")
public class DataSourceServiceImpl implements DataSourceService{


    @Autowired
    DataSourceDao dataSourceDao;



    @Override
    public List<TableFieldBean> getTableDescribe(String tableName) {
        return dataSourceDao.getTableDescribe(tableName);
    }

    @Override
    public List getAllTableDescribe(String dbName) {
        return getTableListByDataSourceName(dbName);
    }

    @Override
    public Map<String, List<Map<String, List<TableFieldBean>>>> getAllTableDescribe() {
        Map<String,List<Map<String,List<TableFieldBean>>>> resMap = new HashMap<String, List<Map<String, List<TableFieldBean>>>>();
        resMap.put("NHCBDP_userInfo_db",getTableListByDataSourceName("NHCBDP_userInfo_db"));
        resMap.put("NHCBDP_test_db",getTableListByDataSourceName("NHCBDP_test_db"));

        return resMap;
    }

    @Override
    public String commitRequestNote(RequestNote requestNote) {
        return dataSourceDao.insertRequestNote(requestNote);
    }

    private List<Map<String,List<TableFieldBean>>> getTableListByDataSourceName(String dbName) {
        List<Map<String,List<TableFieldBean>>> tableList = new ArrayList<Map<String, List<TableFieldBean>>>();

        if (dbName.equals("NHCBDP_userInfo_db")) {
            List<DbTablesBean>        tableNameList = dataSourceDao.getTableListFromDataSource1();
            tableList = getTableListByDataSourceName1(tableNameList);

        } else if (dbName.equals("NHCBDP_test_db")) {
            List<DbTablesBean> tableNameList = dataSourceDao.getTableListFromDataSource2();
            tableList = getTableListByDataSourceName2(tableNameList);
        }

          return tableList;
    }

    private List<Map<String,List<TableFieldBean>>> getTableListByDataSourceName1(List<DbTablesBean> tableNameList) {
        List<Map<String,List<TableFieldBean>>> tableList = new ArrayList<Map<String, List<TableFieldBean>>>();
        Map<String,List<TableFieldBean>> tableFieldListMap ;

        for(DbTablesBean dbTablesBean :tableNameList){
            tableFieldListMap= new HashMap<String, List<TableFieldBean>>();
            tableFieldListMap.put(dbTablesBean.getTableName(),dataSourceDao.getTableDescribe(dbTablesBean.getTableName()));
            tableList.add(tableFieldListMap);
        }
   return  tableList;
    }

    private List<Map<String,List<TableFieldBean>>> getTableListByDataSourceName2(List<DbTablesBean> tableNameList) {
        List<Map<String,List<TableFieldBean>>> tableList = new ArrayList<Map<String, List<TableFieldBean>>>();
        Map<String,List<TableFieldBean>> tableFieldListMap ;

        for(DbTablesBean dbTablesBean :tableNameList){
            tableFieldListMap= new HashMap<String, List<TableFieldBean>>();
            tableFieldListMap.put(dbTablesBean.getTableName(),dataSourceDao.getTableDescribe2(dbTablesBean.getTableName()));
            tableList.add(tableFieldListMap);
        }
   return  tableList;
    }
}
