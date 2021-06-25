package packagePL;


public class Kredit {
    public String vergabeDatum;
    public String faelligkeitsDatum;
    public double betrag;
    public double zinssatz;



    public Kredit(String vergabeDatum, String faelligkeitsDatum, double betrag, double zinssatz) {
        this.vergabeDatum = vergabeDatum;
        this.faelligkeitsDatum = faelligkeitsDatum;
        this.betrag = betrag;
        this.zinssatz = zinssatz;

    }
}
