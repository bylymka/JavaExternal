package epam.task7.web.exceptions;

public class WrongPasswordException extends Exception
{
    public WrongPasswordException()
    {
        super();
    }

    public WrongPasswordException(String message)
    {
        super(message);
    }

    public WrongPasswordException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public WrongPasswordException(Throwable cause)
    {
        super(cause);
    }

    protected WrongPasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
