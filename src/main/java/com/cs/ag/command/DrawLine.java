package com.cs.ag.command;

/**
 * *
 *
 * <p>This class is for the LineRenderer Command implementation
 *
 * <p>*
 */
import com.cs.ag.receiver.ShapeRenderer;

public class DrawLine implements DrawShape {

    private ShapeRenderer lineRenderer;

    public DrawLine(ShapeRenderer lineRenderer) {
        this.lineRenderer = lineRenderer;
    }

    @Override
    public String execute() throws Exception {
        return lineRenderer.renderShape();
    }
}
