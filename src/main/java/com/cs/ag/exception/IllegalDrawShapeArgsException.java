package com.cs.ag.exception;

public class IllegalDrawShapeArgsException extends RuntimeException {

    public IllegalDrawShapeArgsException() {
        super();
    }

    public IllegalDrawShapeArgsException(Throwable cause) {
        super(cause);
    }

    public IllegalDrawShapeArgsException(String message) {
        super(message);
    }

    public IllegalDrawShapeArgsException(String message, Throwable cause) {
        super(message, cause);
    }
}
