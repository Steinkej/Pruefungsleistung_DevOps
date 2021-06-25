package packagePL;

import java.util.Date;

public class Kredit {
    public Date vergabeDatum;
    public Date faelligkeitsDatum;
    public double betrag;
    public int kreditID;


    public Kredit(Date vergabeDatum, Date faelligkeitsDatum, double betrag,int kreditID) {
        this.vergabeDatum = vergabeDatum;
        this.faelligkeitsDatum = faelligkeitsDatum;
        this.betrag = betrag;
        this.kreditID = kreditID;
    }
}
