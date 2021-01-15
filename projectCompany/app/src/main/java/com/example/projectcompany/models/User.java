package com.example.projectcompany.models;

public class User {
    private int id,mobileno;
    private String firstname,lastname,emailid,address,gender,birthdate,profilepic,password,confirmpassword;

    public User(int id, String firstname, String lastname, String emailid, String address, String gender, String birthdate, String profilepic, int mobileno, String password, String confirmpassword) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailid = emailid;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
        this.profilepic = profilepic;
        this.mobileno = mobileno;
        this.password=password;
        this.confirmpassword=confirmpassword;
    }

//    public User() {
//    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMobileno(int mobileno) {
        this.mobileno = mobileno;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public int getMobileno() {
        return mobileno;
    }

    public String getPassword() { return password; }

    public String getConfirmpassword() {
        return confirmpassword;
    }
}

