package sample.metodaFabrykujaca.typyOsob;

import sample.dekorator.Ksiazka;
import sample.metodaFabrykujaca.Osoba;

import java.util.List;

public class Sprzedawca extends Osoba {


    @Override
    public Osoba getPracownik() {
        return this;
    }


    @Override
    public String getImie() {
        return null;
    }

    @Override
    public String getNazwisko() {
        return null;
    }





    @Override
    public Ksiazka aktualizuj(Ksiazka ksiazka) {
        return null;
    }
}