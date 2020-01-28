package com.lelabs.testapplication.data;

import java.io.Serializable;

/**
 * Created by angeooo on 28-Jan-20.
 */
public class UserModel implements Serializable {
    private int id;
    private String name;
    private String username;
    private String email;
    private AddressModel address;
    private String phone;
    private String website;
    private CompanyModel company;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public AddressModel getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public CompanyModel getCompany() {
        return company;
    }
}

/*
{
        "id": 1,
        "name": "Leanne Graham",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "address": {
        "street": "Kulas Light",
        "suite": "Apt. 556",
        "city": "Gwenborough",
        "zipcode": "92998-3874",
        "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"
        }
        },
        "phone": "1-770-736-8031 x56442",
        "website": "hildegard.org",
        "company": {
        "name": "Romaguera-Crona",
        "catchPhrase": "Multi-layered client-server neural-net",
        "bs": "harness real-time e-markets"
        }
        }*/
