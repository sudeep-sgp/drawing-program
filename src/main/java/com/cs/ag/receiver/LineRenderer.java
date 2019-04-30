package com.cs.ag.receiver;

/**
 *
 * This class used for implementing the operations for canvas render
 *
 *
 * */
import com.cs.ag.utils.ReceiverHelper;

public class LineRenderer extends ShapeRenderer {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private char c;

    public LineRenderer(int x1, int y1, int x2, int y2, char c) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.c = c;
    }

    public LineRenderer(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public String renderShape() {
        String renderedShape = null;
        char[][] rootShape = getRootShape();
        ReceiverHelper.constructLine(this.x1, this.y1, this.x2, this.y2, rootShape, c);
        renderedShape = ReceiverHelper.printShape(getRootShape());
        return renderedShape;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}
