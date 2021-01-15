package com.example.retrologin.models;

public class User {
    private int id;
    private String firstname,lastname,emailid,address,gender,birthdate,profilepic,mobileno;

    public User(int id, String firstname, String lastname, String emailid, String address, String gender, String birthdate, String profilepic, String mobileno) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.emailid = emailid;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
        this.profilepic = profilepic;
        this.mobileno = mobileno;
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

    public String getMobileno() {
        return mobileno;
    }
}
