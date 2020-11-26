package Backend;

public abstract class ANWEISUNG
{
    protected String anweisung;
    protected String standard;
    protected String trenner;
    protected String oder = "x&| ";
    protected String schluesselwort;
    protected String ende = " ";
    protected STATIC_DATA daten;
    //Anweisung ausgeben:
    public String anweisung_Ausgeben() throws Exception
    {
        String anw = schluesselwort;
        anw += anweisung;
        anw += ende;
        return anw;
    }
    //Bei Bedarf Trenner einfügen oder Standard entfernen:
    protected void vorbereitung()
    {
        if(anweisung == standard)
            anweisung = "";
        if((anweisung != "") && !(anweisung.endsWith(trenner) || anweisung.endsWith(oder)))
            anweisung += trenner;
    }
    //Bei Bedarf Trenner entfernen oder Standard einfügen:
    protected void vorbereitung_rueckgaengig()
    {
        //Bei Bedarf Trenner entfernen:
        String zwei_trenner = trenner + trenner;
        anweisung.replace(zwei_trenner, trenner);
        String zwei_oder = oder + oder;
        anweisung.replace(zwei_oder, oder);
        String trenner_oder = trenner + oder;
        anweisung.replace(trenner_oder, trenner);
        String oder_trenner = oder + trenner;
        anweisung.replace(oder_trenner, oder);
        boolean endePasstNicht = true;
        do
        {
            if(anweisung.endsWith(trenner))
                anweisung = anweisung.substring(0, (anweisung.length() - trenner.length()));
            else if(anweisung.endsWith(oder))
                anweisung = anweisung.substring(0, (anweisung.length() - oder.length()));
            else
                endePasstNicht = false;
        }
        while(endePasstNicht);
        //Bei Bedarf Standard einfügen:
        if(anweisung == "")
            anweisung = standard;
    }
    public void zuruecksetzen()
    {
        anweisung = standard;
    }
    abstract void argumentTesten(String zuTesten) throws Exception;
}
