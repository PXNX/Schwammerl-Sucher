package Backend;

public class MyIllegalArgumentException extends IllegalArgumentException
{
    MyIllegalArgumentException(String meldung)
    {
        super(meldung);
    }
    @Override
    public String getMessage()
    {
        String message = "Dieser Fehler ist im von uns geschriebenen Backend aufgetreten:";
        message += System.lineSeparator();
        message += super.getMessage();
        return message;
    }
    @Override
    public void printStackTrace()
    {
        System.out.println(getMessage());
        StackTraceElement[] st = super.getStackTrace();
        for(int i = 1; i < st.length; ++i)
        {
            System.out.println(st[i]);
        }
    }
}
