package sample.metodaFabrykujaca;

import sample.Obserwator;
import sample.dekorator.Ksiazka;
import sample.metodaFabrykujaca.typyOsob.E_Osoby;

import java.io.Serializable;
import java.net.PasswordAuthentication;
import java.util.List;

public abstract class Osoba implements Serializable,Obserwator {

    protected String imie;
    protected String nazwisko;
    protected String login;
    protected String haslo;
    protected String email;


    public abstract Osoba getPracownik();

    public abstract String getImie();

    public abstract String getNazwisko();


    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //  protected E_Osoby stanowisko;

    //    public E_Osoby getStanowisko() {
//        return stanowisko;
//    }
//
//    public void setStanowisko(E_Osoby stanowisko) {
//        this.stanowisko = stanowisko;
//    }
}
