package cn.edu.usts.cs2018.entity;

public class Activity {
    public int activityid;
    public int userid;
    public String username;
    public String activityname;
    public String activityplace;


    public String start_time;
    public String end_time;
    public Float general_budget;
    public String description;
    public int max_member;
    public int min_member;
    public String create_time;
    public String status;

    public Activity() {
    }

    public Activity(int activityid, int userid, String username, String activityname, String activityplace, String start_time, String end_time, Float general_budget, String description, int max_member, int min_member, String create_time, String status) {
        this.activityid = activityid;
        this.userid = userid;
        this.username = username;
        this.activityname = activityname;
        this.activityplace = activityplace;
        this.start_time = start_time;
        this.end_time = end_time;
        this.general_budget = general_budget;
        this.description = description;
        this.max_member = max_member;
        this.min_member = min_member;
        this.create_time = create_time;
        this.status = status;
    }

    public Activity(int userid, String username, String activityname) {
        this.userid = userid;
        this.username = username;
        this.activityname = activityname;
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

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Float getGeneral_budget() {
        return general_budget;
    }

    public void setGeneral_budget(Float general_budget) {
        this.general_budget = general_budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMax_member() {
        return max_member;
    }

    public void setMax_member(int max_member) {
        this.max_member = max_member;
    }

    public int getMin_member() {
        return min_member;
    }

    public void setMin_member(int min_member) {
        this.min_member = min_member;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActivityplace() {
        return activityplace;
    }

    public void setActivityplace(String activityplace) {
        this.activityplace = activityplace;
    }

    public String toString()
    {
        return "[" + activityid + ", "+activityname+"," + userid + ", " +username+","+activityplace + ", " +
                start_time + ", " + end_time + ", " + general_budget+", " + description+ ", " + min_member+", " + max_member+", " + create_time+", " + status+"]";
    }
}
