package org.frenzy.core;


public class FrenzyException extends Exception {

    public FrenzyException() {
        super();
    }

    public FrenzyException(String message) {
        super(message);

    }

    public FrenzyException(String message, Throwable cause) {
        super(message, cause);
    }

    protected FrenzyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FrenzyException(Throwable cause) {
        super(cause);
    }
}
