package com.lelabs.testapplication.utils;

public class UtilMethods {
    public static String getFirstTwo(String fullname) {
        String firstTwo = "";
        String[] parts = fullname.split(" ");
        if(parts.length==1){
            firstTwo=firstTwo.substring(0,2);
        }else {
            firstTwo+=parts[0].substring(0,1);
            firstTwo+=parts[parts.length-1].substring(0,1);
        }
        return firstTwo;
    }
}
