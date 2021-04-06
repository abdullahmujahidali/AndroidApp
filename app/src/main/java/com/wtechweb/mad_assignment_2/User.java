package com.wtechweb.mad_assignment_2;

public class User {
    int srNo;
    String id;
    String name;
    double marks;
    public User(){
        srNo=0;
        marks=0.00;
    }
    public User(int sr,String id, String name, double marks){
        this.srNo=sr;
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
    public void setSrNo(int srNo){
        this.srNo=srNo;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setMarks(double marks){
        this.marks=marks;
    }
    public int getSrNo(){
        return srNo;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getMarks(){
        return marks;
    }
    public String toString(){
        return srNo+" "+id+" "+name+" "+marks+"\n";
    }
}
