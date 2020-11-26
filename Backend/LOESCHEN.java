package Backend;

public class LOESCHEN
{
    public FROM_ANWEISUNG from_anweisung;
    public WHERE_ANWEISUNG where_anweisung;
    private DATENBANK datenbank;
    private String sql_befehl;
    private int aenderungen;
    public LOESCHEN(DATENBANK db) throws Exception
    {
        from_anweisung = new FROM_ANWEISUNG();
        where_anweisung = new WHERE_ANWEISUNG();
        zuruecksetzen();
    }
    public LOESCHEN(String datenbankadresse) throws Exception
    {
        datenbank = new DATENBANK(datenbankadresse);
        from_anweisung = new FROM_ANWEISUNG();
        where_anweisung = new WHERE_ANWEISUNG();
        zuruecksetzen();
    }
    public int loeschen_ausfuehren() throws Exception
    {
        befehlGenerieren();
        aenderungen = datenbank.Aendern(sql_befehl);
        return aenderungen;
    }
    private void befehlGenerieren() throws Exception
    {
        sql_befehl = "DELETE ";
        sql_befehl += from_anweisung.anweisung_Ausgeben();
        sql_befehl += where_anweisung.anweisung_Ausgeben();
    }
    public void zuruecksetzen() throws Exception
    {
        from_anweisung.zuruecksetzen();
        where_anweisung.zuruecksetzen();
        sql_befehl = "";
        aenderungen = 0;
    }
}
