package com.cs.ag.command;

import com.cs.ag.constant.TestConstant;
import com.cs.ag.receiver.CanvasRenderer;
import com.cs.ag.receiver.RectangleRenderer;
import com.cs.ag.receiver.ShapeRenderer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class DrawRectangleTest {
    private DrawCanvas canvasCommand;
    private ShapeRenderer shapeRenderer;
    private DrawRectangle rectangleCommand;

    @BeforeEach
    void setUp() {
        CanvasRenderer.initCanvas(20, 4);
        shapeRenderer = CanvasRenderer.getInstance();
        canvasCommand = new DrawCanvas(shapeRenderer);
        shapeRenderer = new RectangleRenderer(14, 1, 18, 3);
        rectangleCommand = new DrawRectangle(shapeRenderer);
    }

    @AfterEach
    void tearDown() {}

    @Test
    void rectangleCommandExecutionTest() {
        assumingThat(
                shapeRenderer.getHeight() == 6 && shapeRenderer.getWidth() == 22,
                () -> {
                    System.out.println(
                            "Checking whether the canvasRenderer rendered is same as the expected");
                    assertEquals(TestConstant.CANVAS_EXPECTED_RESULT, canvasCommand.execute());
                    System.out.println(
                            "Checking whether the DrawRectngle command is executing as expected");
                    assertEquals(
                            TestConstant.RECTANGLE_EXPECTED_SINGLE_RESULT,
                            rectangleCommand.execute());
                });
    }
}
