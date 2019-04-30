package com.cs.ag.exception;

public class CommandNotFoundException extends RuntimeException {

    public CommandNotFoundException() {
        super();
    }

    public CommandNotFoundException(Throwable cause) {
        super(cause);
    }

    public CommandNotFoundException(String message) {
        super(message);
    }

    public CommandNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
