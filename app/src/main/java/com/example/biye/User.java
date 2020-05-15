package com.example.biye;

public class User {
    private  String Sjmc;
    private  String Grade;
    public String getSjmc(){
        return Sjmc;
    }
    public void setSjmc(String Sjmc){
        this.Sjmc = Sjmc;
    }
    public String getGrade(){
        return Grade;
    }
    public  void setGrade(String Grade){
        this.Grade = Grade;
    }
    @Override
    public String toString(){
        return "User [Sjmc="+Sjmc+",Grade=                                                      "+Grade+"]";
    }
}
