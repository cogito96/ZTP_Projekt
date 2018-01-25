package sample;

import sample.dekorator.Ksiazka;
import sample.metodaFabrykujaca.FabrykaAdministrator;
import sample.metodaFabrykujaca.FabrykaOsob;
import sample.metodaFabrykujaca.FabrykaSprzedawcow;
import sample.metodaFabrykujaca.Osoba;
import sample.models.Autor;
import sample.models.Kategoria;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BazaDanych {

    public Osoba osobaZalogowana;


    public Osoba getOsobaZalogowana() {
        return osobaZalogowana;
    }

    public void setOsobaZalogowana(Osoba osobaZalogowana) {
        this.osobaZalogowana = osobaZalogowana;
    }

    public List<Kategoria> listaKategorii = new ArrayList<>();
    public List<Ksiazka> listaKsiazek = new ArrayList<>();
    public List<Autor> listaAutorow = new ArrayList<>();

    public List<Osoba> listaAdministratorow = new ArrayList<>();
    public List<Osoba> listaPracownikow = new ArrayList<>();

    private static BazaDanych bazadanych;

    private BazaDanych() { }

    public static BazaDanych getBaza()
    {
        if (bazadanych == null)
        {
            bazadanych = new BazaDanych();
            bazadanych.wczytajDane();

        }
        return bazadanych;

    }


    public void dodajAutora (Autor autor)
    {
        bazadanych.listaAutorow.add(autor);
        zapiszAutoraDOPliku();
    }
    public void dodajKategorie (Kategoria kategoria)
    {
        bazadanych.listaKategorii.add(kategoria);
        zapiszKategorieDOPliku();
    }
    public void usunKategorie ( Kategoria kategoria)
    {
        bazadanych.listaKategorii.remove(kategoria);
    }

    public void dodajKsiazke ( Ksiazka ksiazka)
    {
        bazadanych.listaKsiazek.add(ksiazka);
        zapiszKsiazkeDOPliku();
    }
    public void usunKsiazke (Ksiazka ksiazka) {
        bazadanych.listaKsiazek.remove(ksiazka);
        zapiszKsiazkeDOPliku();
    }

    public void dodajAdministratora(Osoba osoba)
    {
        bazadanych.listaAdministratorow.add(osoba);
    }

    public void dodajPracownika(Osoba osoba)
    {
        bazadanych.listaPracownikow.add(osoba);
    }

    public void wczytajDane()
    {
        wczytajKategorieZPliku();
        wczytajAutoraZPliku();
        wczytajKsiazkiPliku();



        FabrykaOsob fabrykaOsob = new FabrykaAdministrator();
        Osoba osoba = fabrykaOsob.stworz();
        osoba.setImie("Administrator");
        osoba.setNazwisko("Nowak");
        osoba.setEmail("Administrator@nowak.pl");
        osoba.setLogin("admin");
        osoba.setHaslo("admin");
        bazadanych.listaAdministratorow.add(osoba);

        FabrykaOsob fabrykaOsob1 = new FabrykaSprzedawcow();
        Osoba osoba1 = fabrykaOsob1.stworz();
        osoba1.setImie("Sprzedawca");
        osoba1.setNazwisko("Kowalski");
        osoba1.setEmail("Sprzedawca@p.pl");
        osoba1.setLogin("pracownik");
        osoba1.setHaslo("pracownik");
        bazadanych.listaPracownikow.add(osoba1);
    }


    public void wczytajAutoraZPliku()
    {
        File autorzyPlik = new File("autorzy.txt");
        ObjectInputStream autorzyIn = null;

        try{
            autorzyIn = new ObjectInputStream(new FileInputStream(autorzyPlik));
            Object o = autorzyIn.readObject();
            bazadanych.listaAutorow = (List<Autor>) o;
        }catch(IOException | ClassNotFoundException e) { e.printStackTrace(); }
    }

    public void zapiszAutoraDOPliku()
    {
        File file = new File("autorzy.txt");
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try{
            fileOut = new FileOutputStream(file);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(bazadanych.listaAutorow);
            out.close();
        }catch(IOException e) { e.printStackTrace(); }
    }

    public void wczytajKategorieZPliku()
    {
        File kategoriaPlik = new File("kategorie.txt");
        ObjectInputStream kategorieIn = null;

        try{
            kategorieIn = new ObjectInputStream(new FileInputStream(kategoriaPlik));
            Object o = kategorieIn.readObject();
            bazadanych.listaKategorii = (List<Kategoria>) o;
        }catch(IOException | ClassNotFoundException e) { e.printStackTrace(); }
    }

    public void zapiszKategorieDOPliku()
    {
        File file = new File("kategorie.txt");
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try{
            fileOut = new FileOutputStream(file);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(bazadanych.listaKategorii);
            out.close();
        }catch(IOException e) { e.printStackTrace(); }
    }

    public void wczytajKsiazkiPliku()
    {
        File ksiazkiPlik = new File("ksiazki.txt");
        ObjectInputStream ksiazkiIn = null;

        try{
            ksiazkiIn = new ObjectInputStream(new FileInputStream(ksiazkiPlik));
            Object o = ksiazkiIn.readObject();
            bazadanych.listaKsiazek = (List<Ksiazka>) o;
        }catch(IOException | ClassNotFoundException e) { e.printStackTrace(); }
    }

    public void zapiszKsiazkeDOPliku()
    {
        File file = new File("ksiazki.txt");
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try{
            fileOut = new FileOutputStream(file);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(bazadanych.listaKsiazek);
            out.close();
        }catch(IOException e) { e.printStackTrace(); }
    }


}
