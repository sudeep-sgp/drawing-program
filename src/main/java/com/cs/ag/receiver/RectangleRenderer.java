package com.cs.ag.receiver;

import com.cs.ag.utils.ReceiverHelper;
/**
 *
 * This class used for implementing the operations for Rectangle render
 *
 *
 * */

public class RectangleRenderer extends ShapeRenderer {

    private int x1, y1, x2, y2;
    private char c;

    public RectangleRenderer(int x1, int y1, int x2, int y2, char c) {

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.c = c;
    }

    public RectangleRenderer(int x1, int y1, int x2, int y2) {

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /** @return */
    @Override
    public String renderShape() {
        String renderedShape = null;
        char[][] rootShape = getRootShape();
        /** if x1 constant and y1 varies until y2 * */
        ReceiverHelper.constructLine(this.x1, this.y1, this.x1, this.y2, rootShape, c);
        /** if y2 constant and x varies until x2 * */
        ReceiverHelper.constructLine(this.x1, this.y1, this.x2, this.y1, rootShape, c);
        /** if x2 constant and y1 varies until y2 * */
        ReceiverHelper.constructLine(this.x2, this.y1, this.x2, this.y2, rootShape, c);
        /** if y1 constant and x1 varies until x2 * */
        ReceiverHelper.constructLine(this.x1, this.y2, this.x2, this.y2, rootShape, c);
        renderedShape = ReceiverHelper.printShape(rootShape);
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
