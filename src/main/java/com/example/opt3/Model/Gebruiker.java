package com.example.opt3.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import static io.github.palexdev.materialfx.utils.RandomUtils.random;

public abstract class Gebruiker {
        String name;
        Adres adres;
        Omzet omzet;
        Login login;
        public static final ObservableList<Babies> people;
        static {
            people = FXCollections.observableArrayList(
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble())
            );
        }

        public Gebruiker(){

        }


     public Gebruiker(String name, String straat, String postcode, int huisnummer, double loon, double totaleomzet, int uren, String username, String password) {
            this.adres = new Adres();
            this.omzet = new Omzet();
            this.login = new Login();

            this.name = name;
            this.adres.setStraatnaam(straat);
            this.adres.setPostcode(postcode);
            this.adres.setHuisnummer(huisnummer);
            this.omzet.setLoon(loon);
            this.omzet.setTotaleOmzet(totaleomzet);
            this.omzet.setTotaleUren(uren);
            this.login.setUsername(username);
            this.login.setPassword(password);
        }


        public static int randomInt(){
            int max = 5;
            int min = 0;
            return random.nextInt(max - min + 1) + min;
        }

        public static double randomDouble(){
        double max = 10000;
        double min = 0;
        return random.nextDouble(max - min + 1) + min;
    }

        public boolean loginCheck(String un, String pw){
        return un.equals(login.getUsername()) && pw.equals(login.getPassword());
    }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Adres getAdres() {
            return adres;
        }

        public void setAdres(Adres adres) {
            this.adres = adres;
        }

        abstract void profielAanmaken();
    }
