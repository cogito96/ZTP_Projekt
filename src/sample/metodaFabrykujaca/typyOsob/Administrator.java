package sample.metodaFabrykujaca.typyOsob;


import sample.dekorator.Ksiazka;
import sample.metodaFabrykujaca.Osoba;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Administrator extends Osoba  {


    @Override
    public Osoba getPracownik() {

        return this;
    }

    @Override
    public String getImie() {
        return this.imie;
    }

    @Override
    public String getNazwisko() {
        return this.nazwisko;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", login='" + login + '\'' +
                '}';
    }


    @Override
    public Ksiazka aktualizuj(Ksiazka ksiazka) {
        System.out.println("Adminie " + this.getImie());
        System.out.println("W magazynie brakuje ksiazki o tytule " + ksiazka.getTytul());

        return ksiazka;
    }



}
