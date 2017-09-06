package NHCBDP.webModule.Dao;

import NHCBDP.webModule.Domain.User;
import NHCBDP.webModule.Domain.UserTest;
import NHCBDP.webModule.DynamicDataSource.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;
import java.util.UUID;

/**
 * @author wbliu
 * @create 2017-09-04 17:03
 **/


@Repository("userDao")
public class UserDaoImpl implements UserDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public User selectByUserNameAndPassword(User user) {
        return jdbcTemplate.queryForObject("select * from users where userName=? AND password =?", new Object[]{user.getUserName(),user.getPassword()}, new UserRowMapper());
    }


    @Override
    public int insert(final User user) {
        final String sql = "insert into users(id,username,password) values(?,?,?)";

        String userId = UUID.randomUUID().toString();
        Object [] valueObject = new Object[]{userId,user.getUserName(),user.getPassword()};
        int [] typeArray = new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR};

        return jdbcTemplate.update(sql,valueObject,typeArray);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users", new UserRowMapper());
    }


    @Override
    @TargetDataSource(name = "ds1")
    @Transactional(readOnly = true)
    public List<UserTest> findAllForDs1(String tableName) {

        String sql = "SELECT  * FROM "+tableName;
        return jdbcTemplate.query(sql,new UserTestRowMapper());
    }



    @Override
    @Transactional(readOnly = true)
    public User findUserById(int id) {
        return jdbcTemplate.queryForObject("select * from users where id=?", new Object[]{id}, new UserRowMapper());
    }


    @Override
    public void delete(final Integer id) {
        final String sql = "delete from users where id=?";
        jdbcTemplate.update(sql,
                new Object[]{id},
                new int[]{java.sql.Types.INTEGER});
    }

    @Override
    public void update(final User user) {
        jdbcTemplate.update(
                "update users set name=?,email=? where id=?",
                new Object[]{user.getUserName(), user.getPassword(),user.getId()});
    }

    @Override
    public int selectByUserName(String userName) {
        String sql = "select * from users where userName='"+userName+"'";

        List<User> userList = jdbcTemplate.query(sql,new UserRowMapper());


        return userList.size();
    }

}



class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setId(rs.getString("id"));
        user.setUserName(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setIsUsable(rs.getInt("isUsable"));

        return user;
    }
}


class UserTestRowMapper implements RowMapper<UserTest> {

    @Override
    public UserTest mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserTest user = new UserTest();

        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}