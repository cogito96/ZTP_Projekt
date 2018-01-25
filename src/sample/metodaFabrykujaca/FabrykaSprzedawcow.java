package sample.metodaFabrykujaca;

import sample.metodaFabrykujaca.typyOsob.Sprzedawca;

public class FabrykaSprzedawcow implements FabrykaOsob{


    @Override
    public Osoba stworz() {
        return new Sprzedawca();
    }
}
