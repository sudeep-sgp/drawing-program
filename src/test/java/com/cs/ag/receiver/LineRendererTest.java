package com.cs.ag.receiver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static com.cs.ag.constant.TestConstant.LINE_EXPECTED_JOINED_RESULT;
import static com.cs.ag.constant.TestConstant.LINE_EXPECTED_SINGLE_RESULT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(JUnitPlatform.class)
public class LineRendererTest {

    private CanvasRenderer canvassetup;
    private char[][] rootShape;
    private String expectedShapeSingle;

    @BeforeEach
    void setUp() {
        CanvasRenderer.initCanvas(20, 4);
        canvassetup = CanvasRenderer.getInstance();
        canvassetup.renderShape();
        rootShape = canvassetup.getRootShape();
    }

    @Test
    void renderShapeTest() {
        assumingThat(
                canvassetup.getRootShape().length == 6
                        && canvassetup.getRootShape()[0].length == 22,
                () -> {
                    System.out.println(
                            "Checking whether the shape lineRenderer rendered is same as the expected");
                    LineRenderer lineRenderer;
                    lineRenderer = new LineRenderer(1, 2, 6, 2);
                    assertEquals(LINE_EXPECTED_SINGLE_RESULT, lineRenderer.renderShape());
                    lineRenderer = new LineRenderer(6, 3, 6, 4);
                    assertEquals(LINE_EXPECTED_JOINED_RESULT, lineRenderer.renderShape());
                });
    }

    @AfterAll
    void afterAll() {
        for (char[] array : rootShape) {
            Arrays.fill(array, ' ');
        }
    }
}
