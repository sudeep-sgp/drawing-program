package com.cs.ag.command;

import com.cs.ag.constant.TestConstant;
import com.cs.ag.receiver.CanvasRenderer;
import com.cs.ag.receiver.FillRenderer;
import com.cs.ag.receiver.ShapeRenderer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class DrawFillTest {
    private DrawCanvas canvasCommand;
    private ShapeRenderer shapeRenderer;
    private DrawFill fillCommand;

    @BeforeEach
    void setUp() {
        CanvasRenderer.initCanvas(20, 4);
        shapeRenderer = CanvasRenderer.getInstance();
        canvasCommand = new DrawCanvas(shapeRenderer);
        shapeRenderer = new FillRenderer(10, 3, "o");
        fillCommand = new DrawFill(shapeRenderer);
    }

    @AfterEach
    void tearDown() {}

    @Test
    void fillCommandExecutionTest() {
        assumingThat(
                shapeRenderer.getHeight() == 6 && shapeRenderer.getWidth() == 22,
                () -> {
                    System.out.println(
                            "Checking whether the canvasRenderer rendered fill shape is same as the expected");
                    assertEquals(TestConstant.CANVAS_EXPECTED_RESULT, canvasCommand.execute());
                    assertEquals(TestConstant.FILL_EXPECTED_SINGLE_RESULT, fillCommand.execute());
                });
    }
}
