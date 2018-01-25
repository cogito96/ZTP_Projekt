package sample.metodaFabrykujaca;

import sample.metodaFabrykujaca.typyOsob.Administrator;

public class FabrykaAdministrator implements FabrykaOsob{


    @Override
    public Osoba stworz() {
        return new Administrator();
    }
}
