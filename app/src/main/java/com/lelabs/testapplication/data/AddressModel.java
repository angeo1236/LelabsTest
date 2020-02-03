package com.lelabs.testapplication.data;

import java.io.Serializable;

/**
 * Created by angeooo on 28-Jan-20.
 */
public class AddressModel implements Serializable {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoModel geo;
    public class GeoModel{
        private String lat;
        private String lng;

        public String getLat() {
            return lat;
        }

        public String getLng() {
            return lng;
        }
    }

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public GeoModel getGeo() {
        return geo;
    }
}

/*
"address": {
        "street": "Kulas Light",
        "suite": "Apt. 556",
        "city": "Gwenborough",
        "zipcode": "92998-3874",
        "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"
        }
        }*/
