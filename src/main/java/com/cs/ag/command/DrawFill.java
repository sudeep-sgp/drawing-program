package com.cs.ag.command;

/** This class is for the concrete implementation of Fill command */
import com.cs.ag.receiver.ShapeRenderer;

public class DrawFill implements DrawShape {

    private ShapeRenderer fillRenderer;

    public DrawFill(ShapeRenderer fillRenderer) {
        this.fillRenderer = fillRenderer;
    }

    @Override
    public String execute() throws Exception {
        return this.fillRenderer.renderShape();
    }
}
