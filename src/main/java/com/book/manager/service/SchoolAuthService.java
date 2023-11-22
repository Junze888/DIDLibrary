package com.book.manager.service;

public class SchoolAuthService {
    private boolean verifyIdentity(String ID){

        return true;
    }

    private String SignWithID(String ID){
        if (verifyIdentity(ID)){
            //
        }
        return "11";
    }

}
