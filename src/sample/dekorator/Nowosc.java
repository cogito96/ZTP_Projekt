package sample.dekorator;

public class Nowosc extends RodzajKsiazki {

    public Nowosc(Ksiazka ksiazka) {
        super(ksiazka);
    }

    @Override
    public int getCena()  {
        return super.ksiazka.getCena() + 10;
    }


    @Override
    public String getTagi() {
        return super.ksiazka.getTagi() + " Nowosc";
    }

}
