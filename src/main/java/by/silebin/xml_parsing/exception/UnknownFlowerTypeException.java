package by.silebin.xml_parsing.exception;

public class UnknownFlowerTypeException extends Exception {
    public UnknownFlowerTypeException() {
    }

    public UnknownFlowerTypeException(String message) {
        super(message);
    }

    public UnknownFlowerTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownFlowerTypeException(Throwable cause) {
        super(cause);
    }
}
