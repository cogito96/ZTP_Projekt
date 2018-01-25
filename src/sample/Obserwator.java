package sample;

import sample.dekorator.Ksiazka;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public interface Obserwator {
    public Ksiazka aktualizuj(Ksiazka ksiazka);

}
