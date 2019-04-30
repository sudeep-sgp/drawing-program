package com.cs.ag.constant;

public enum FillerConstants {
    CANVAS_BOARDER_H('-'),
    CANVAS_BOARDER_V('|'),
    DEFAULT_FILLER('x');

    private char filler;

    public char getFiller() {
        return filler;
    }

    FillerConstants(char filler) {
        this.filler = filler;
    }
}
