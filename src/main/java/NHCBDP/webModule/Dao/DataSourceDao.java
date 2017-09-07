package NHCBDP.webModule.Dao;

import NHCBDP.webModule.Domain.DbTablesBean;
import NHCBDP.webModule.Domain.RequestNote;
import NHCBDP.webModule.Domain.TableFieldBean;
import NHCBDP.webModule.DynamicDataSource.TargetDataSource;

import java.util.List;
import java.util.Map;

/**
 * @author wbliu
 * @create 2017-09-05 16:39
 **/

public interface DataSourceDao {
    List<TableFieldBean> getTableDescribe(String tableName);

    List<DbTablesBean> getTableList(String dbName);

    List<DbTablesBean> getTableListFromDataSource1();

    @TargetDataSource(name = "ds1")
    List<DbTablesBean> getTableListFromDataSource2();

    List<TableFieldBean>  getTableDescribe2(String tableName);

    String insertRequestNote(RequestNote requestNote);

    List<RequestNote>  selectRequestNote(String userName);

    List<RequestNote>  selectRequestNoteByRequestNoteId(String requestNoteId);
}
