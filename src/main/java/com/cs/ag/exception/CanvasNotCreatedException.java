package com.cs.ag.exception;

public class CanvasNotCreatedException extends Exception {

    public CanvasNotCreatedException() {
        super();
    }

    public CanvasNotCreatedException(Throwable cause) {
        super(cause);
    }

    public CanvasNotCreatedException(String message) {
        super(message);
    }

    public CanvasNotCreatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
