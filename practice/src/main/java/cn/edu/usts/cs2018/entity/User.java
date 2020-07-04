package cn.edu.usts.cs2018.entity;

public class User {
    public int userid;
    public String username;
    public String password;
    public String telephone;
    public String address;

    public User(String username, String password, String telephone, String address) {
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.address = address;
    }

    public User() {
    }

    public User(int userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int userid, String username, String password, String telephone, String address) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telephone=" + telephone +
                ", address='" + address + '\'' +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
