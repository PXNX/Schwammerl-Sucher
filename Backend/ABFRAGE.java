package Backend;

import java.sql.*;
public class ABFRAGE
{
    public SELECT_ANWEISUNG select_anweisung;
    public FROM_ANWEISUNG from_anweisung;
    public WHERE_ANWEISUNG where_anweisung;
    private STATIC_DATA daten;
    private ResultSet ergebnis;
    private String sql_abfrage;
    private DATENBANK datenbank;
    private RESULTSETCONVERTER converter;
    //Konstruktoren:
    public ABFRAGE(DATENBANK db) throws Exception
    {
        datenbank = db;
        select_anweisung = new SELECT_ANWEISUNG();
        from_anweisung = new FROM_ANWEISUNG();
        where_anweisung = new WHERE_ANWEISUNG();
        converter = new RESULTSETCONVERTER(select_anweisung);
        zuruecksetzen();
    }
    public ABFRAGE(String datenbankadresse) throws Exception
    {
        datenbank = new DATENBANK(datenbankadresse);
        select_anweisung = new SELECT_ANWEISUNG();
        from_anweisung = new FROM_ANWEISUNG();
        where_anweisung = new WHERE_ANWEISUNG();
        converter = new RESULTSETCONVERTER(select_anweisung);
        zuruecksetzen();
    }
    //Destruktor:
    protected void finalize() throws Exception
    {
        ergebnis.close();
    }
    public String[][] abfrage_ausfuehren() throws Exception
    {
        abfrageGenerieren();
        ergebnis = datenbank.Abfrage(sql_abfrage);
        return converter.update_select(select_anweisung).ergebnisUmwandelnStandard(ergebnis);
    }
    public String[][] ergebnis_standard()  throws Exception
    {
        return converter.ergebnisUmwandelnStandard(ergebnis);
    }
    public String[] ergebnis_Zeilen(String trenner) throws Exception
    {
        return converter.ergebnisUmwandelnZeilen(ergebnis, trenner);
    }
    public String ergebnis_ganz(String trenner) throws Exception
    {
        return converter.ergebnisUmwandelnGanz(ergebnis, trenner);
    }
    public void zuruecksetzen() throws Exception
    {
        select_anweisung.zuruecksetzen();
        from_anweisung.zuruecksetzen();
        where_anweisung.zuruecksetzen();
        sql_abfrage = "";
    }
    private void abfrageGenerieren() throws Exception
    {
        sql_abfrage = "";
        sql_abfrage += select_anweisung.anweisung_Ausgeben();
        sql_abfrage += from_anweisung.anweisung_Ausgeben();
        sql_abfrage += where_anweisung.anweisung_Ausgeben();
    }
}
