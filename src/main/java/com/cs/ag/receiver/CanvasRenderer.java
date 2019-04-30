package com.cs.ag.receiver;
/**
 *
 * This class used for implementing the operations for canvas render
 *
 *
 * */
import com.cs.ag.constant.FillerConstants;
import com.cs.ag.utils.ReceiverHelper;

/** */
public class CanvasRenderer extends ShapeRenderer {

    private static CanvasRenderer CANVAS_SINGLE_INSTANCE = null;
    private int width;
    private int height;

    private CanvasRenderer(int width, int height) {
        super(width, height);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static CanvasRenderer getInstance() {
        if (CANVAS_SINGLE_INSTANCE == null) {
            throw new AssertionError("Please call initCanvas method first");
        }
        return CANVAS_SINGLE_INSTANCE;
    }

    public static CanvasRenderer initCanvas(int width, int h) {
        if (CANVAS_SINGLE_INSTANCE == null) {
            synchronized (CanvasRenderer.class) {
                if (CANVAS_SINGLE_INSTANCE == null) {
                    CANVAS_SINGLE_INSTANCE = new CanvasRenderer(width + 2, h + 2);
                }
            }
        }
        return CANVAS_SINGLE_INSTANCE;
    }

    @Override
    public String renderShape() {
        String renderedShape = null;
        char[][] shape = getRootShape();
        /** Constructing bottom horizontal line * */
        ReceiverHelper.constructLine(
                0, 0, this.width - 1, 0, shape, FillerConstants.CANVAS_BOARDER_H.getFiller());
        /** Constructing top horizontal line * */
        ReceiverHelper.constructLine(
                0,
                this.height - 1,
                this.width - 1,
                this.height - 1,
                shape,
                FillerConstants.CANVAS_BOARDER_H.getFiller());
        /** Constructing left vertical line * */
        ReceiverHelper.constructLine(
                0, 1, 0, this.height - 2, shape, FillerConstants.CANVAS_BOARDER_V.getFiller());
        /** Constructing right vertical line * */
        ReceiverHelper.constructLine(
                this.width - 1,
                1,
                this.width - 1,
                this.height - 2,
                shape,
                FillerConstants.CANVAS_BOARDER_V.getFiller());
        /** Filling blank char within the border of CanvasRenderer * */
        ReceiverHelper.floodFiller(shape, this.width - 2, this.height - 2, ' ');
        /** Printing the canvas on terminal * */
        renderedShape = ReceiverHelper.printShape(shape);

        return renderedShape;
    }
}
