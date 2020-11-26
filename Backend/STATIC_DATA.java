package Backend;

public class STATIC_DATA
{
    public String[] spalte;
    public String[] tabelle;
    public STATIC_DATA()
    {
        //spalte fuellen:
        spalte[0] = "Dateinummer";      //Integer
        spalte[1] = "Dateiname";        //Text
        spalte[2] = "Format";           //Text
        spalte[3] = "Kategorie";        //Text
        spalte[4] = "Ersteller";        //Text
        spalte[5] = "Erstellungsdatum"; //Date
        spalte[6] = "Dauer";            //Time
        spalte[7] = "Größe";            //Integer
        spalte[8] = "Daten/Bitrate";    //Integer
        spalte[9] = "Favorit";          //Boolean
        //tabelle fuellen:
        tabelle[0] = "sortierdaten";
    }
}
