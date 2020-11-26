package Backend;

import java.sql.*;
public class RESULTSETCONVERTER
{
    private STATIC_DATA daten;
    private SELECT_ANWEISUNG select_anweisung;
    private String trenner = "\t|\t";
    private String neue_zeile = "\n";
    public RESULTSETCONVERTER(SELECT_ANWEISUNG s_a)
    {
        select_anweisung = s_a;
    }
    public RESULTSETCONVERTER update_select(SELECT_ANWEISUNG s_a)
    {
        select_anweisung = s_a;
        return this;
    }
    public String[][] ergebnisUmwandelnStandard(ResultSet ergebnis_alt)  throws Exception
    {
        //Ueber Kopie Länge erkennen:
        ResultSet ergebnis_alt_2 = ergebnis_alt;
        int laenge = 0;
        while(ergebnis_alt_2.next())
            laenge++;
        String[][] ergebnis = new String[laenge][select_anweisung.anzahl_spalten];
        int sp, sp_a, z = 0;
        while(ergebnis_alt.next())
        {
            sp = 0;
            for(sp_a = 0; sp_a < daten.spalte.length; sp_a++)
            {
                if(select_anweisung.select[sp_a])
                {
                    if(sp_a == 9)
                    {
                        if(ergebnis_alt.getBoolean(daten.spalte[sp_a]))
                            ergebnis[z][sp] = "ja";
                        else
                            ergebnis[z][sp] = "nein";
                    }
                    else
                    {
                        ergebnis[z][sp] = ergebnis_alt.getString(daten.spalte[sp_a]);
                    }
                    sp++;
                }
            }
            z++;
        }
        return ergebnis;
    }
    public String[] ergebnisUmwandelnZeilen(ResultSet ergebnis_alt, String trenner)  throws Exception
    {
        ResultSet ergebnis_alt_2 = ergebnis_alt;
        int laenge = 0;
        while(ergebnis_alt_2.next())
            laenge++;
        String[] ergebnis = new String[laenge];
        String temp_zeile = "";
        int z = 0;
        while(ergebnis_alt.next())
        {
            for(int sp_a = 0; sp_a < daten.spalte.length; sp_a++)
            {
                if(select_anweisung.select[sp_a])
                {
                    if(sp_a == 9)
                    {
                        if(ergebnis_alt.getBoolean(daten.spalte[sp_a]))
                            temp_zeile += "ja";
                        else
                            temp_zeile += "nein";
                    }
                    else
                    {
                        temp_zeile += ergebnis_alt.getString(daten.spalte[sp_a]);
                    }
                    temp_zeile += trenner;
                }
            }
            ergebnis[z] = temp_zeile;
            z++;
        }
        return ergebnis;
    }
    public String ergebnisUmwandelnGanz(ResultSet ergebnis_alt, String trenner)  throws Exception
    {
        String ergebnis = "";
        String temp_zeile = "";
        while(ergebnis_alt.next())
        {
            for(int sp_a = 0; sp_a < daten.spalte.length; sp_a++)
            {
                if(select_anweisung.select[sp_a])
                {
                    if(sp_a == 9)
                    {
                        if(ergebnis_alt.getBoolean(daten.spalte[sp_a]))
                            temp_zeile += "ja";
                        else
                            temp_zeile += "nein";
                    }
                    else
                    {
                        temp_zeile += ergebnis_alt.getString(daten.spalte[sp_a]);
                    }
                    temp_zeile += trenner;
                }
            }
            ergebnis += temp_zeile;
            ergebnis += System.lineSeparator();
        }
        return ergebnis;
    }
}
