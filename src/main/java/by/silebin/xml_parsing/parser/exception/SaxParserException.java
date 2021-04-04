package by.silebin.xml_parsing.parser.exception;

public class SaxParserException extends Exception {
    public SaxParserException() {
    }

    public SaxParserException(String message) {
        super(message);
    }

    public SaxParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaxParserException(Throwable cause) {
        super(cause);
    }
}
