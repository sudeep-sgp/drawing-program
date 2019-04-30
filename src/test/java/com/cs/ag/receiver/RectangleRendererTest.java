package com.cs.ag.receiver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static com.cs.ag.constant.TestConstant.RECTANGLE_EXPECTED_SINGLE_RESULT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(JUnitPlatform.class)
public class RectangleRendererTest {
    private CanvasRenderer canvasSetup;
    private char[][] rootShape;

    @BeforeEach
    void setUp() {
        CanvasRenderer.initCanvas(20, 4);
        canvasSetup = CanvasRenderer.getInstance();
        canvasSetup.renderShape();
        rootShape = canvasSetup.getRootShape();
    }

    @Test
    void renderShapeTest() {
        RectangleRenderer rectangleRenderer = new RectangleRenderer(14, 1, 18, 3);
        assumingThat(
                canvasSetup.getRootShape().length == 6
                        && canvasSetup.getRootShape()[0].length == 22,
                () -> {
                    System.out.println(
                            "Checking whether the rectangle rendered is same as the expected");
                    assertEquals(RECTANGLE_EXPECTED_SINGLE_RESULT, rectangleRenderer.renderShape());
                });
    }

    @AfterAll
    void afterAll() {
        for (char[] array : rootShape) {
            Arrays.fill(array, ' ');
        }
    }
}
