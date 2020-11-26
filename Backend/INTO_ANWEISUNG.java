package Backend;

public class INTO_ANWEISUNG extends FROM_ANWEISUNG
{
    public INTO_ANWEISUNG()
    {
        standard = daten.tabelle[0];
        schluesselwort = "INTO ";
        anweisung = standard;
    }
    @Override
    public void tabelle_hinzufuegen(String name) throws Exception
    {
        argumentTesten(name);
        anweisung = name;
    }
}
