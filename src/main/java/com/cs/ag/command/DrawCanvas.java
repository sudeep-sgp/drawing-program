package com.cs.ag.command;

/** This class is for the concrete implementation of Canvas creation command */
import com.cs.ag.receiver.ShapeRenderer;

public class DrawCanvas implements DrawShape {

    private ShapeRenderer canvasRenderer;

    public DrawCanvas(ShapeRenderer canvasRenderer) {
        this.canvasRenderer = canvasRenderer;
    }

    @Override
    public String execute() throws Exception {
        return canvasRenderer.renderShape();
    }
}
