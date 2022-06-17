package com.example.opt3.Model;

import java.util.ArrayList;

public class Login {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public boolean loginCheck(String un, String pw){
        Database database = new Database();
        ArrayList<Gebruiker> gebruikers = database.reader2("Gebruiker.json");



        for (Gebruiker gebruiker: gebruikers) {

            if (un.equals(gebruiker.login.getUsername()) && pw.equals(gebruiker.login.getPassword())){

                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

}
