package com;
public class Student {
    String fname;
    String lname;
    String age;
    String email;
    String gender;
    String address;

    public Student(String fname, String lname, String age, String email, String gender, String address){
        this.fname=fname;
        this.lname=lname;
        this.age=age;
        this.email=email;
        this.gender=gender;
        this.address=address;
    }
    public Student(){

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
