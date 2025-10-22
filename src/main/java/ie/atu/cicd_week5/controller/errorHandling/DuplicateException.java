package ie.atu.cicd_week5.controller.errorHandling;

public class DuplicateException extends RuntimeException
{
    private String message;
    private String field;
    public DuplicateException(String field, String message)
    {
        this.field = field;
    }
    public DuplicateException(String message)
    {
        super(message);
    }
}
