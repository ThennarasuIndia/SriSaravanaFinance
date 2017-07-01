package com.saravana.finance.Utils;

/**
 * Created by THENNA on 3/16/2017.
 */
public class Utility {


    public static boolean isValidString(String value) {
        if(value!=null && value.length()>0){
            return true;
        }else {
            return false;
        }
    }
}
