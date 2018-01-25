package sample.dekorator;

import sample.Obserwator;
import sample.ObserwowanyObiekt;
import sample.models.Autor;
import sample.models.Kategoria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Ksiazka implements Serializable, ObserwowanyObiekt{



    private String tytul;

    private Kategoria kategoria;

    private Autor autor;

    private String opis;

    private String tagi;

    private int cena;

    private int cenaZBonusami;

    private int iloscKsiazek ;

    public void setCena(int cena) {
        this.cena = cena;
    }

    public abstract int getCena();

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getCenaZBonusami() {
        return cenaZBonusami;
    }

    public void setCenaZBonusami(int cenaZBonusami) {
        this.cenaZBonusami = cenaZBonusami;
    }

    public abstract String getTagi();

    public void setTagi(String tagi) {
        this.tagi = tagi;
    }

    public int getIloscKsiazek() {
        return iloscKsiazek;
    }

    public void setIloscKsiazek(int iloscKsiazek) {
        this.iloscKsiazek = iloscKsiazek;
    }

    @Override
    public String toString() {
        return
                "Tytul " + tytul + ", Autor " + autor + ", Kategoria " + kategoria + ", Cena za sztuke " + cena;
    }






    protected List<Obserwator> obserwatorzy = new ArrayList<Obserwator>();


    public void powiadom()
    {
        System.out.println("Jestem obserwatorem \n");
        if(this.getIloscKsiazek() == 0)
        {
            powiadomObserwatorow();
        }
    }

    @Override
    public void dodajObserwatora(Obserwator obserwator)
    {
        obserwatorzy.add(obserwator);
    }
    @Override
    public void usunObserwatora(Obserwator obserwator )
    {
        obserwatorzy.remove(obserwator);
    }

    @Override
    public void powiadomObserwatorow()
    {
        for(Obserwator o: obserwatorzy)
        {
            o.aktualizuj(this);
        }
    }

}