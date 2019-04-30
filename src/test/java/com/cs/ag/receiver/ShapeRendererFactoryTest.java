package com.cs.ag.receiver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@RunWith(JUnitPlatform.class)
public class ShapeRendererFactoryTest {
    String[] commandC, commandL, commandR, commandB;
    CanvasRenderer canvasRenderer;
    LineRenderer lineRenderer;
    RectangleRenderer rectangleRenderer;
    FillRenderer fillRenderer;

    @BeforeEach
    void setUp() {
        commandC = new String[] {"C", "20", "4"};
        commandL = new String[] {"L", "1", "2", "6", "2"};
        commandR = new String[] {"R", "14", "1", "18", "3"};
        commandB = new String[] {"B", "10", "3", "o"};
        CanvasRenderer.initCanvas(20, 4);
        canvasRenderer = CanvasRenderer.getInstance();
        lineRenderer = new LineRenderer(1, 2, 6, 2);
        rectangleRenderer = new RectangleRenderer(14, 1, 18, 3);
        fillRenderer = new FillRenderer(10, 3, "o");
    }

    @AfterEach
    void tearDown() {}

    @Test
    void getShapeRendererTest() {
        assumingThat(
                canvasRenderer.getHeight() == 6 && canvasRenderer.getWidth() == 22,
                () -> {
                    assertEquals(canvasRenderer, ShapeRendererFactory.getShapeRenderer(commandC));
                    System.out.println(
                            " Success! Tested whether the object created by factory method is as expected");
                });
    }
}
