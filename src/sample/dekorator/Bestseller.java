package sample.dekorator;

public class Bestseller extends RodzajKsiazki {


    public Bestseller(Ksiazka ksiazka) {
        super(ksiazka);
    }

    @Override
    public int getCena()  {
        return super.ksiazka.getCena() + 6;
    }


    @Override
    public String getTagi() {
        return super.ksiazka.getTagi() + " Bestseller";
    }
}
