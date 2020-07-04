package cn.edu.usts.cs2018.entity;

public class UserActivity {
    public int activityid;
    public int userid;
    public String username;
    public float pay;
    public String pay_activity;

    public UserActivity() {
    }

    @Override
    public String toString() {
        return "UserActivity{" +
                "activityid=" + activityid +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", pay=" + pay +
                ", pay_activity='" + pay_activity + '\'' +
                '}';
    }

    public UserActivity(int activityid, int userid, String username, float pay, String pay_activity) {
        this.activityid = activityid;
        this.userid = userid;
        this.username = username;
        this.pay = pay;
        this.pay_activity = pay_activity;
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

    public float getPay() {
        return pay;
    }

    public void setPay(float pay) {
        this.pay = pay;
    }

    public String getPay_activity() {
        return pay_activity;
    }

    public void setPay_activity(String pay_activity) {
        this.pay_activity = pay_activity;
    }
}
