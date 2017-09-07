package NHCBDP.webModule.Services;

import NHCBDP.webModule.Domain.RequestNote;
import NHCBDP.webModule.Domain.TableFieldBean;

import java.util.List;
import java.util.Map;

/**
 * @author wbliu
 * @create 2017-09-05 16:34
 **/

public interface DataSourceService {
    List getTableDescribe(String tableName);

    List  getAllTableDescribe(String dbName);

    Map<String,List<Map<String,List<TableFieldBean>>>>  getAllTableDescribe();

    String   commitRequestNote(RequestNote requestNote);
}
