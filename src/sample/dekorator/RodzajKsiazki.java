package sample.dekorator;

public class RodzajKsiazki extends Ksiazka {

    protected Ksiazka ksiazka;

    public RodzajKsiazki(Ksiazka ksiazka)
    {
        this.ksiazka = ksiazka;
    }


    @Override
    public String getTagi() {
        return null;
    }

    @Override
    public int getCena() {
        return 0;
    }

}