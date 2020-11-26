package Backend;

import java.util.Arrays;
public class FROM_ANWEISUNG extends ANWEISUNG
{
    public FROM_ANWEISUNG()
    {
        standard = "sortierdaten";
        trenner = ", ";
        schluesselwort = "FROM ";
        anweisung = standard;
    }
    @Override
    protected void argumentTesten(String zuTesten) throws Exception
    {
        if(zuTesten == "")
            throw new MyIllegalArgumentException("Bitte keinen leeren String als Argument!");
        if(!Arrays.asList(daten.tabelle).contains(zuTesten))    //Wenn zuTesten nicht in daten.tabelle (= keine gültige Tabelle):
            throw new MyIllegalArgumentException(zuTesten + " ist keine gültige Tabelle");
    }
    public void tabelle_hinzufuegen(String name) throws Exception
    {
        argumentTesten(name);
        vorbereitung();
        anweisung += name;
        //Sicherheitshalber:
        vorbereitung_rueckgaengig();
    }
    public void tabelle_entfernen(String name)
    {
        anweisung.replace(name, "");
        vorbereitung_rueckgaengig();
    }
}
