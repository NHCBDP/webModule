package NHCBDP.webModule.Domain;

/**
 * @author wbliu
 * @create 2017-09-05 19:25
 **/


public class DbTablesBean {
 String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "DbTablesBean{" +
                "tableName='" + tableName + '\'' +
                '}';
    }
}
