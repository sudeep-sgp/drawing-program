package com.cs.ag.command;

import com.cs.ag.constant.TestConstant;
import com.cs.ag.receiver.CanvasRenderer;
import com.cs.ag.receiver.LineRenderer;
import com.cs.ag.receiver.ShapeRenderer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class DrawLineTest {
    private DrawCanvas canvasCommand;
    private ShapeRenderer shapeRenderer;
    private DrawLine lineCommand;

    @BeforeEach
    void setUp() {
        CanvasRenderer.initCanvas(20, 4);
        shapeRenderer = CanvasRenderer.getInstance();
        canvasCommand = new DrawCanvas(shapeRenderer);
        shapeRenderer = new LineRenderer(1, 2, 6, 2);
        lineCommand = new DrawLine(shapeRenderer);
    }

    @AfterAll
    static void tearDown() {}

    @Test
    void lineCommandExecutionTest() {
        assumingThat(
                shapeRenderer.getHeight() == 6 && shapeRenderer.getWidth() == 22,
                () -> {
                    System.out.println("Checking whether the canvas command executed as expected");
                    assertEquals(TestConstant.CANVAS_EXPECTED_RESULT, canvasCommand.execute());
                    System.out.println("Checking whether the line command executed as expected");
                    assertEquals(TestConstant.LINE_EXPECTED_SINGLE_RESULT, lineCommand.execute());
                });
    }
}
