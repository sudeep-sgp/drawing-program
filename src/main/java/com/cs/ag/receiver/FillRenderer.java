package com.cs.ag.receiver;
/**
 *
 * This class used for implementing the operations for Fill render
 *
 *
 * */
import com.cs.ag.utils.ReceiverHelper;

public class FillRenderer extends ShapeRenderer {

    private int x;
    private int y;
    private String c;

    public FillRenderer(int x, int y, String c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    @Override
    public String renderShape() {
        String renderedShape;
        char[][] rootShape = getRootShape();
        ReceiverHelper.floodFiller(rootShape, x, y, this.c.charAt(0));
        renderedShape = ReceiverHelper.printShape(getRootShape());
        return renderedShape;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getC() {
        return c;
    }
}
