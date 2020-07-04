package cn.edu.usts.cs2018.entity;

public class Worker {
    public int id;
    public String number;
    public String name;
    public String password;
    public String telephone;
    public String work_count;

    public Worker() {
    }

    public Worker(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Worker(String number, String name, String password, String telephone, String work_count) {
        this.number = number;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.work_count = work_count;
    }

    public Worker(int id, String number, String name, String password, String telephone, String work_count) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.work_count = work_count;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", work_count='" + work_count + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getWork_count() {
        return work_count;
    }

    public void setWork_count(String work_count) {
        this.work_count = work_count;
    }
}
