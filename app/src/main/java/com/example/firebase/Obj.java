package com.example.firebase;

public class Obj {
    int id,phone;
    String name;
    Obj(int id,String name,int phone)
    {
        this.id=id;
        this.name=name;
        this.phone=phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
