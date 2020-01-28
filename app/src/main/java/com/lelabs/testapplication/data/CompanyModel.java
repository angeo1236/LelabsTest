package com.lelabs.testapplication.data;

import java.io.Serializable;

/**
 * Created by angeooo on 28-Jan-20.
 */
public class CompanyModel implements Serializable {
    private String name;
    private String catchPhrase;
    private String bs;

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}


/*
 "company": {
         "name": "Romaguera-Crona",
         "catchPhrase": "Multi-layered client-server neural-net",
         "bs": "harness real-time e-markets"
         }*/
