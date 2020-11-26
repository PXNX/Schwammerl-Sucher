package Backend;

public class WHERE_ANWEISUNG extends ANWEISUNG
{
    public WHERE_ANWEISUNG()
    {
        standard = "TRUE";
        trenner = " && ";
        oder = " || ";
        schluesselwort = "WHERE ";
        anweisung = standard;
    }
    @Override
    protected void argumentTesten(String zuTesten) throws Exception
    {
        if(zuTesten == "")
            throw new MyIllegalArgumentException("Bitte keinen leeren String als Argument!");
        if(zuTesten.endsWith("= "))
            throw new MyIllegalArgumentException("Anweisung unvollstaendig!");
    }
    //Anweisung hinzufügen:
    public void anweisung_hinzufuegen(String anw) throws Exception
    {
        argumentTesten(anw);
        vorbereitung();
        anweisung += anw;
        //Sicherheitshalber:
        vorbereitung_rueckgaengig();
    }
    //Anweisung entfernen:
    private void anweisung_entfernen(String anw)
    {
        anweisung.replace(anw, "");
        vorbereitung_rueckgaengig();
    }
    //'oder' ("||") hinzufügen:
    public WHERE_ANWEISUNG oder_hinzufuegen()
    {
        anweisung += oder;
        return this;
    }
    //Dateiname:
    public WHERE_ANWEISUNG dateiname_setzen(String name) throws Exception
    {
        argumentTesten(name);
        anweisung_hinzufuegen("Dateiname = '+name'");
        return this;
    }
    public WHERE_ANWEISUNG dateiname_setzen_rueckgaengig(String name)
    {
        anweisung_entfernen("Dateiname = '+name'");
        return this;
    }
    //Format:
    public WHERE_ANWEISUNG format_setzen(String format) throws Exception
    {
        argumentTesten(format);
        anweisung_hinzufuegen("Format = '+format'");
        return this;
    }
    public WHERE_ANWEISUNG format_setzen_rueckgaengig(String format)
    {
        anweisung_entfernen("Format = '+format'");
        return this;
    }
    //Kategorie:
    public WHERE_ANWEISUNG kategorie_setzen(String kat) throws Exception
    {
        argumentTesten(kat);
        anweisung_hinzufuegen("Kategorie = '+kat'");
        return this;
    }
    public WHERE_ANWEISUNG kategorie_setzen_rueckgaengig(String kat)
    {
        anweisung_entfernen("Kategorie = '+kat'");
        return this;
    }
    //Ersteller:
    public WHERE_ANWEISUNG ersteller_setzen(String er) throws Exception
    {
        argumentTesten(er);
        anweisung_hinzufuegen("Ersteller = '+er'");
        return this;
    }
    public WHERE_ANWEISUNG ersteller_setzen_rueckgaengig(String er)
    {
        anweisung_entfernen("Ersteller = '+er'");
        return this;
    }
    //Erstellungsdatum:
    public WHERE_ANWEISUNG erstellungsdatum_setzen(String datum) throws Exception
    {
        argumentTesten(datum);
        anweisung_hinzufuegen("Erstellungsdatum = '+datum'");
        return this;
    }
    public WHERE_ANWEISUNG erstellungsdatum_setzen_rueckgaengig(String datum)
    {
        anweisung_entfernen("Erstellungsdatum = '+datum'");
        return this;
    }
    //Dauer:
    public WHERE_ANWEISUNG dauer_setzen(String d) throws Exception
    {
        argumentTesten(d);
        anweisung_hinzufuegen("Dauer = '+d'");
        return this;
    }
    public WHERE_ANWEISUNG dauer_setzen_rueckgaengig(String d)
    {
        anweisung_entfernen("Dauer = '+d'");
        return this;
    }
    //Größe:
    public WHERE_ANWEISUNG groesse_setzen(String g) throws Exception
    {
        argumentTesten(g);
        anweisung_hinzufuegen("Größe = '+g'");
        return this;
    }
    public WHERE_ANWEISUNG groesse_setzen_rueckgaengig(String g)
    {
        anweisung_entfernen("Größe = '+g'");
        return this;
    }
    //Daten/Bitrate:
    public WHERE_ANWEISUNG daten_bitrate_setzen(String db) throws Exception
    {
        argumentTesten(db);
        anweisung_hinzufuegen("Daten/Bitrate = '+db'");
        return this;
    }
    public WHERE_ANWEISUNG daten_bitrate_setzen_rueckgaengig(String db)
    {
        anweisung_entfernen("Daten/Bitrate = '+db'");
        return this;
    }
    //Favorit:
    public WHERE_ANWEISUNG favorit() throws Exception   //ohne Parameter => nur Favoriten:
    {
        anweisung_hinzufuegen("Favorit");
        return this;
    }
    public WHERE_ANWEISUNG favorit_rueckgaengig()
    {
        anweisung_entfernen("Favorit");
        return this;
    }
    public WHERE_ANWEISUNG favorit(boolean f) throws Exception  //mit Parameter:
    {
        String fav = Boolean.toString(f);
        argumentTesten(fav);
        anweisung_hinzufuegen("Favorit = '+fav'");
        return this;
    }
    public WHERE_ANWEISUNG favorit_rueckgaengig(boolean f)
    {
        String fav = Boolean.toString(f);
        anweisung_entfernen("Favorit = '+fav'");
        return this;
    }
}
