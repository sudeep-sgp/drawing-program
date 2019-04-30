package com.cs.ag.receiver;

/**
 * This class used for abstracting the receiver operations ( core business logic) and serving as a
 * common platform for all the concrete implementations.
 */
public abstract class ShapeRenderer {

    private static char[][] rootShape;

    public ShapeRenderer() {}

    public ShapeRenderer(int w, int h) {
        this.rootShape = new char[h][w];
    }

    public char[][] getRootShape() {
        return rootShape;
    }

    public void setRootShape(char[][] rootShape) {
        this.rootShape = rootShape;
    }

    public abstract String renderShape() throws Exception;

    public int getWidth() {
        return 0;
    };

    public int getHeight() {
        return 0;
    };
}
