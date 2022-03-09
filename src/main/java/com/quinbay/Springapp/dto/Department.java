package com.quinbay.Springapp.dto;

public class Department {

    private int dpt_id;
    private String d_name;
    private String desig;


    public Department(){}
    public Department(int dpt_id, String d_name, String desig){
        this.dpt_id=dpt_id;
        this.d_name=d_name;
        this.desig=desig;
    }


    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getD_name() {

        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public int getDpt_id() {

        return dpt_id;
    }

    public void setDpt_id(int dpt_id) {
        this.dpt_id = dpt_id;
    }
}
