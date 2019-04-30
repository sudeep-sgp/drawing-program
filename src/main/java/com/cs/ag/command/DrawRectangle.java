package com.cs.ag.command;
/** This class is for the concrete implementation of Rectangle command */
import com.cs.ag.receiver.ShapeRenderer;

public class DrawRectangle implements DrawShape {

    private ShapeRenderer rectangleRenderer;

    public DrawRectangle(ShapeRenderer rectangleRenderer) {
        this.rectangleRenderer = rectangleRenderer;
    }

    @Override
    public String execute() throws Exception {
        return rectangleRenderer.renderShape();
    }

}
