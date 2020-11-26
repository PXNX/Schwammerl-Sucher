package Backend;

import java.util.Arrays;
public class VALUES_ANWEISUNG extends ANWEISUNG
{
    private String[] werte;
    public VALUES_ANWEISUNG()
    {
        werte = new String[daten.spalte.length];
        for(int i = 0; i < werte.length; ++i)
            werte[i] = "";
        trenner = ", ";
        schluesselwort = "VALUES (";
        ende = ") ";
        this.favorit();
    }
    @Override
    protected void argumentTesten(String zuTesten)
    {
        if(zuTesten == "")
            throw new MyIllegalArgumentException("Bitte keinen leeren String als Argument!");
    }
    private void anweisung_generieren() throws Exception
    {
        for(int i = 0; i < werte.length; ++i)
        {
            if(werte[i] == "")
                throw new MyIllegalArgumentException("Nicht alle Werte festgelegt!!!");
            if(anweisung != "")
                anweisung += trenner;
            anweisung += werte[i];
        }
    }
    @Override
    public String anweisung_Ausgeben() throws Exception
    {
        anweisung_generieren();
        return super.anweisung_Ausgeben();
    }
    private void wert_hinzufuegen(int spalte, String wert)
    {
        argumentTesten(wert);
        werte[spalte] = "'"+wert+"'";
    }
    //Dateinummer:
    public void dateinummer(int dn)
    {
        wert_hinzufuegen(Arrays.asList(daten.spalte).indexOf("Dateinummer"), String.valueOf(dn));
    }
    //Dateiname:
    public void dateiname(String dn)
    {
        wert_hinzufuegen(Arrays.asList(daten.spalte).indexOf("Dateiname"), dn);
    }
    //Format:
    public void format(String f)
    {
        wert_hinzufuegen(Arrays.asList(daten.spalte).indexOf("Format"), f);
    }
    //Kategorie:
    public void kategorie(String k)
    {
        wert_hinzufuegen(Arrays.asList(daten.spalte).indexOf("Kategorie"), k);
    }
    //Ersteller:
    public void ersteller(String e)
    {
        wert_hinzufuegen(Arrays.asList(daten.spalte).indexOf("Ersteller"), e);
    }
    //Erstellungsdatum:
    public void datum(String d)
    {
        wert_hinzufuegen(Arrays.asList(daten.spalte).indexOf("Erstellungsdatum"), d);
    }
    //Dauer:
    public void dauer(String d)
    {
        wert_hinzufuegen(Arrays.asList(daten.spalte).indexOf("Dauer"), d);
    }
    //Groesse:
    public void groesse(int g)
    {
        wert_hinzufuegen(Arrays.asList(daten.spalte).indexOf("Größe"), String.valueOf(g));
    }
    //Daten/Bitrate:
    public void daten_bitrate(int d_b)
    {
        wert_hinzufuegen(Arrays.asList(daten.spalte).indexOf("Daten/Bitrate"), String.valueOf(d_b));
    }
    //Favorit:
    public void favorit(boolean f)
    {
        wert_hinzufuegen(Arrays.asList(daten.spalte).indexOf("Favorit"), String.valueOf(f));
    }
    //default (kein Favorit):
    public void favorit()
    {
        this.favorit(false);
    }
    //TODO: einzelne werte!!!!!!!!!!!!!
}
