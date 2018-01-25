package sample.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.PasswordField;

public class Klient {


    private StringProperty property = new SimpleStringProperty(this,"imieKlienta");
    private String imie;

    private String nazwisko;

    private String email;

    private String login;

    private PasswordField haslo;

    private Kategoria kategoria;

    public Klient(String imie, String nazwisko, String email, String login, PasswordField haslo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.login = login;
        this.haslo = haslo;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public PasswordField getHaslo() {
        return haslo;
    }

    public void setHaslo(PasswordField haslo) {
        this.haslo = haslo;
    }
}
