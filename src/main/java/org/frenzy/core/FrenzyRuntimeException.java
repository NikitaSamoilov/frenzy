package org.frenzy.core;

public class FrenzyRuntimeException extends RuntimeException {
    public FrenzyRuntimeException() {
        super();
    }

    public FrenzyRuntimeException(String message) {
        super(message);
    }

    public FrenzyRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FrenzyRuntimeException(Throwable cause) {
        super(cause);
    }

    protected FrenzyRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
