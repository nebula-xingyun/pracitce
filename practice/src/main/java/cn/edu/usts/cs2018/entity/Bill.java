package cn.edu.usts.cs2018.entity;

public class Bill {
    public int activityid;
    public int userid;
    public String username;
    public float total;
    public float self_budget;
    public float price;

    public Bill() {
    }

    public Bill(int activityid, int userid, String username, float total, float self_budget, float price) {
        this.activityid = activityid;
        this.userid = userid;
        this.username = username;
        this.total = total;
        this.self_budget = self_budget;
        this.price = price;
    }

    public int getActivityid() {
        return activityid;
    }

    public void setActivityid(int activityid) {
        this.activityid = activityid;
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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getSelf_budget() {
        return self_budget;
    }

    public void setSelf_budget(float self_budget) {
        this.self_budget = self_budget;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "activityid=" + activityid +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", total=" + total +
                ", self_budget=" + self_budget +
                ", price=" + price +
                '}';
    }
}
