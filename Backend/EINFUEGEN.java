package Backend;

public class EINFUEGEN
{
    public INTO_ANWEISUNG into_anweisung;
    public VALUES_ANWEISUNG values_anweisung;
    private STATIC_DATA daten;
    private DATENBANK datenbank;
    private String sql_befehl;
    private int aenderungen;
    public EINFUEGEN(DATENBANK db)
    {
        datenbank = db;
        sql_befehl = "";
        aenderungen = 0;
        into_anweisung = new INTO_ANWEISUNG();
        values_anweisung = new VALUES_ANWEISUNG();
    }
    public EINFUEGEN(String datenbankadresse) throws Exception
    {
        datenbank = new DATENBANK(datenbankadresse);
        sql_befehl = "";
        aenderungen = 0;
        into_anweisung = new INTO_ANWEISUNG();
        values_anweisung = new VALUES_ANWEISUNG();
    }
    public int einfuegen_ausfuehren() throws Exception
    {
        befehlGenerieren();
        aenderungen = datenbank.Aendern(sql_befehl);
        return aenderungen;
    }
    public void zuruecksetzen() throws Exception
    {
        into_anweisung.zuruecksetzen();
        values_anweisung.zuruecksetzen();
        sql_befehl = "";
        aenderungen = 0;
    }
    private void befehlGenerieren() throws Exception
    {
        sql_befehl = "INSERT ";
        sql_befehl += into_anweisung.anweisung_Ausgeben();
        sql_befehl += values_anweisung.anweisung_Ausgeben();
    }
}
