package NHCBDP.webModule.Domain;

/**
 * @author wbliu
 * @create 2017-09-04 16:57
 **/


public class User {

    String id;
    String userName;
    String password;
    int isUsable;

    public User() {
    }

    public User(String id, String userName, String password, int isUsable) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.isUsable = isUsable;
    }

    public User(String userName, String password, int isUsable) {
        this.userName = userName;
        this.password = password;
        this.isUsable = isUsable;
    }
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsUsable() {
        return isUsable;
    }

    public void setIsUsable(int isUsable) {
        this.isUsable = isUsable;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isUsable=" + isUsable +
                '}';
    }
}

