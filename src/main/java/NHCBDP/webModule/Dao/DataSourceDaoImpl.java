package NHCBDP.webModule.Dao;

import NHCBDP.webModule.Domain.DbTablesBean;
import NHCBDP.webModule.Domain.RequestNote;
import NHCBDP.webModule.Domain.TableFieldBean;
import NHCBDP.webModule.DynamicDataSource.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.UUID;

/**
 * @author wbliu
 * @create 2017-09-05 16:39
 **/


@Repository("dataSourceDao")
public class DataSourceDaoImpl implements DataSourceDao {


    @Autowired
     JdbcTemplate jdbcTemplate;

    @Override
    public List<TableFieldBean> getTableDescribe(String tableName) {
        String sql = "describe "+tableName;
        return jdbcTemplate.query(sql,new TableStructBeanRowMapper());
    }

    @Override
    public List<DbTablesBean> getTableList(String dbName) {
        String sql = "use "+dbName+";show database";
        return jdbcTemplate.query(sql,new DbStructRowMapper());
    }


    @Override
    public List<DbTablesBean> getTableListFromDataSource1() {
        String sql = "show tables WHERE  Tables_in_NHCBDP_userInfo_db not LIKE'%view%'";
        return jdbcTemplate.query(sql,new DbStructRowMapper());
    }


    @TargetDataSource(name = "ds1")
    @Override
    public List<DbTablesBean> getTableListFromDataSource2() {
        String sql = "show tables WHERE Tables_in_NHCBDP_test_db not LIKE'%view%'";
        return jdbcTemplate.query(sql,new DbStructRowMapper());
    }

    @TargetDataSource(name="ds1")
    @Override
    public List<TableFieldBean> getTableDescribe2(String tableName) {
        String sql = "describe "+tableName;
        return jdbcTemplate.query(sql,new TableStructBeanRowMapper());
    }

    @Override
    public String insertRequestNote(RequestNote requestNote) {
        String  requestId = UUID.randomUUID().toString().replace("-","");

        String inserSql = "INSERT INTO requestNote VALUES(?,?,?,?,?,?,0,?)";
        Object [] valueArray = new Object[]{requestId,requestNote.getRequestName(),requestNote.getRequestUserId(),requestNote.getCompanyName(),requestNote.getIllustration(),requestNote.getContent(),requestNote.getUserName()};
        int [] typeArray = new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};




        return jdbcTemplate.update(inserSql,valueArray,typeArray) ==1? requestId:"add error";
    }

    @Override
    public List<RequestNote> selectRequestNote(String userName) {
        String sql = "select * from requestNote WHERE userName='"+userName+"'";



        return jdbcTemplate.query(sql,new RequestNoteRowMapper() );
    }


    class TableStructBeanRowMapper implements RowMapper<TableFieldBean> {

@Override
public TableFieldBean mapRow(ResultSet rs, int rowNum) throws SQLException {
        TableFieldBean tableFieldBean = new TableFieldBean();

        tableFieldBean.setField(rs.getString("Field"));
        tableFieldBean.setType(rs.getString("Type"));
        tableFieldBean.setIsNull(rs.getString("NULL"));
        tableFieldBean.setKey(rs.getString("Key"));
        tableFieldBean.setExtra(rs.getString("Extra"));
        tableFieldBean.setDefault0(rs.getString("Default"));


        return tableFieldBean;
        }
        }

    private class DbStructRowMapper implements RowMapper<DbTablesBean> {

        @Override
        public DbTablesBean mapRow(ResultSet resultSet, int i) throws SQLException {
            DbTablesBean dbTablesBean = new DbTablesBean();
            dbTablesBean.setTableName(resultSet.getString(1));
            return dbTablesBean;
        }
    }

    class RequestNoteRowMapper implements RowMapper<RequestNote> {

        @Override
        public RequestNote mapRow(ResultSet rs, int rowNum) throws SQLException {
            RequestNote requestNote = new RequestNote();

            requestNote.setFormId(rs.getString("formId"));
            requestNote.setRequestName(rs.getString("requestName"));
            requestNote.setRequestUserId(rs.getString("requestUserId"));
            requestNote.setCompanyName(rs.getString("companyName"));
            requestNote.setIllustration(rs.getString("illustration"));
            requestNote.setContent(rs.getString("content"));
            requestNote.setStatus(rs.getInt("status"));
            requestNote.setUserName(rs.getString("userName"));


            return requestNote;
        }
    }


}
