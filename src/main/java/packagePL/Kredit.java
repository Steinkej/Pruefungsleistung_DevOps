package packagePL;

/**
 * Klasse, die Kredite als Objekte erstellt.
 *
 * @author Gruppe3
 * @version 1.0
 */
public class Kredit {
    public String vergabeDatum;
    public String faelligkeitsDatum;
    public double betrag;
    public double zinssatz;


    /**
     * Weist die Parameter für ein Objekt der Klasse Kredit zu.
     * @param vergabeDatum Datum an dem der Kredit vergeben wird.
     * @param faelligkeitsDatum Fälligkeitsdatum des Kredits.
     * @param betrag Betrag/Höhe des Kredits.
     * @param zinssatz Zinssatz für den Kredit.
     */
    public Kredit(String vergabeDatum, String faelligkeitsDatum, double betrag, double zinssatz) {
        this.vergabeDatum = vergabeDatum;
        this.faelligkeitsDatum = faelligkeitsDatum;
        this.betrag = betrag;
        this.zinssatz = zinssatz;

    }
}
