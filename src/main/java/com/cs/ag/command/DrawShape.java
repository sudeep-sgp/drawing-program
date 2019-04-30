package com.cs.ag.command;

/**
 * This Interface is common for all concrete shape implementations such as Canvas, Line, Rectnagle
 * etc. Annotated as @FunctionalInterface, because as of now there is only one method used.
 */
@FunctionalInterface
public interface DrawShape {
    String execute() throws Exception;
    /**
     * Can include more functions in future like undo, redo etc. eg : String undo() throws
     * Exception; ( Need to remove @FunctionalInterface)
     */
}
