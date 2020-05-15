package com.example.biye;

public class Kaoshi {
    private  String Sjmc;
    public String getSjmc(){
        return Sjmc;
    }
    public void setSjmc(String Sjmc){
        this.Sjmc = Sjmc;
    }



    @Override
    public String toString(){
        return "User [Sjmc=                         "+Sjmc+"]";
    }
}
