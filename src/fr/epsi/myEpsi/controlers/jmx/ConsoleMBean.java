package fr.epsi.myEpsi.controlers.jmx;

public class ConsoleMBean implements IConsoleMBean {
    private static String nom = "ConsoleMBean";
    private int valeur = 1;

    public String getNom() {
        return nom;
    }

    public int getValeur() {
        return valeur;
    }

    public synchronized void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void rafraichir() {
        System.out.println("Rafraichir les donnees");

    }

    public ConsoleMBean() {

    }
}
