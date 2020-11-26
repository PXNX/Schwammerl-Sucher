package Backend;

import java.util.Arrays;
public class SELECT_ANWEISUNG extends ANWEISUNG
{
    public int anzahl_spalten;
    public boolean[] select;
    public SELECT_ANWEISUNG()
    {
        standard = "*";
        trenner = ", ";
        schluesselwort = "SELECT ";
        anweisung = standard;
    }
    @Override
    protected void argumentTesten(String zuTesten) throws Exception
    {
        if(zuTesten == "")
            throw new MyIllegalArgumentException("Bitte keinen leeren String als Argument!");
        if(!Arrays.asList(daten.spalte).contains(zuTesten)) //Wenn zuTesten nicht in daten.spalte (= ungültige Spalte):
            throw new MyIllegalArgumentException(zuTesten + " ist keine gültige Spalte");
    }
    public void spalte_hinzufuegen(String name) throws Exception
    {
        argumentTesten(name);
        vorbereitung();
        anweisung += name;
        anzahl_spalten++;
        //Sicherheitshalber:
        vorbereitung_rueckgaengig();
    }
    public void spalte_entfernen(String name)
    {
        anweisung.replace(name, "");
        vorbereitung_rueckgaengig();
        anzahl_spalten--;
    }
    public void spalten_festlegen(boolean[] s) throws Exception
    {
        select = s;
        zuruecksetzen();
        for(int i = 0; i < select.length; ++i)
        {
            if(select[i])
            {
                vorbereitung();
                spalte_hinzufuegen(daten.spalte[i]);
            }
        }
    }
}
