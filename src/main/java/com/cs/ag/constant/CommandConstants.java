package com.cs.ag.constant;

public enum CommandConstants {
    C("CANVAS"),
    L("LINE"),
    R("RECTANGLE"),
    B("FILL"),
    Q("QUIT"),
    H("HELP");

    private String command;

    CommandConstants(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }
}
