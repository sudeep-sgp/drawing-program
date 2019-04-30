package com.cs.ag.receiver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static com.cs.ag.constant.TestConstant.FILL_EXPECTED_SINGLE_RESULT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(JUnitPlatform.class)
public class FillRendererTest {
    private CanvasRenderer canvassetup;
    private char[][] rootShape;

    @BeforeEach
    void setUp() {
        CanvasRenderer.initCanvas(20, 4);
        canvassetup = CanvasRenderer.getInstance();
        canvassetup.renderShape();
        rootShape = canvassetup.getRootShape();
    }

    @Test
    void renderShapeTest() {
        FillRenderer fillRenderer = new FillRenderer(10, 3, "o");
        assumingThat(
                rootShape.length == 6 && rootShape[0].length == 22,
                () -> {
                    System.out.println(
                            "Checking whether the rectangle rendered is same as the expected");
                    assertEquals(FILL_EXPECTED_SINGLE_RESULT, fillRenderer.renderShape());
                });
    }

    @AfterAll
    void tearDown() {
        for (char[] array : canvassetup.getRootShape()) {
            Arrays.fill(array, ' ');
        }
    }
}
