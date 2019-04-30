package com.cs.ag.command;

import com.cs.ag.constant.TestConstant;
import com.cs.ag.receiver.CanvasRenderer;
import com.cs.ag.receiver.ShapeRenderer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@RunWith(JUnitPlatform.class)
public class DrawCanvasTest {
    private DrawCanvas canvasCommand;
    private ShapeRenderer shapeRenderer;

    @BeforeEach
    void setUp() {
        CanvasRenderer.initCanvas(20, 4);
        shapeRenderer = CanvasRenderer.getInstance();
        canvasCommand = new DrawCanvas(shapeRenderer);
    }

    @AfterEach
    void tearDown() {}

    @Test
    void canvasCommandExecutionTest() {
        assumingThat(
                shapeRenderer.getHeight() == 6 && shapeRenderer.getWidth() == 22,
                () -> {
                    System.out.println(
                            "Checking whether the canvas command is executing as expected");
                    assertEquals(TestConstant.CANVAS_EXPECTED_RESULT, canvasCommand.execute());
                });
    }
}
