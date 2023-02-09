package com.example.wj_constractor;

public class Masonary_workers {

   private String id;
   private String fName;
   private String lName;
   private String nic;
   private String age;
   private String phone;
   private String address;
   private String email;

    public Masonary_workers(String id, String fName, String lName, String nic, String age, String phone, String address, String email) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.nic = nic;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }
    public Masonary_workers() {

        this.id = "";
        this.fName ="";
        this.lName ="";
        this.nic ="";
        this.age ="";
        this.phone ="";
        this.address ="";
        this.email ="";
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
