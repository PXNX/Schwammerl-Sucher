package Backend;

import java.sql.*;
public class DATENBANK
{
    Connection conn;
    public DATENBANK(String datenbankadresse) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver"); //.newInstance();
        conn = DriverManager.getConnection(datenbankadresse);
    }
    //Destruktor:
    protected void finalize() throws Exception
    {
        conn.close();
    }
    public ResultSet Abfrage(String abfrage) throws Exception
    {
        Statement stat = conn.createStatement();
        ResultSet erg = stat.executeQuery(abfrage);
        //stat.close();
        return erg;
    }
    public int Aendern(String befehl) throws Exception
    {
        Statement stat = conn.createStatement();
        int aenderungen = stat.executeUpdate(befehl);
        stat.close();
        return aenderungen;
    }
}
