package com.cs.ag.receiver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static com.cs.ag.constant.TestConstant.CANVAS_EXPECTED_RESULT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(JUnitPlatform.class)
public class CanvasRendererTest {

    private static boolean isInitCanvasCalled;
    private static CanvasRenderer canvassetup;
    private CanvasRenderer canvasRenderer = null;
    private static char[][] rootshape;
    private static String expectedShape;

    @BeforeAll
    static void setUp() {
        canvassetup = CanvasRenderer.initCanvas(20, 4);
        if (!canvassetup.equals(null)) isInitCanvasCalled = true;
        rootshape = new char[6][22];
        expectedShape = CANVAS_EXPECTED_RESULT;
    }

    @Test
    void getInstanceTest() {
        assumingThat(
                isInitCanvasCalled,
                () -> {
                    System.out.println("Checking the instance returned by getInstance()");
                    assertEquals(canvassetup, CanvasRenderer.getInstance());
                });
    }

    @Test
    void initCanvasTest() {
        canvasRenderer = CanvasRenderer.initCanvas(20, 4);
        assertEquals(rootshape.length, canvasRenderer.getRootShape().length);
    }

    @Test
    void renderShapeTest() {
        assumingThat(
                canvassetup.getHeight() == 6 && canvassetup.getWidth() == 22,
                () -> {
                    System.out.println(
                            "Checking whether the canvasRenderer rendered is same as the expected");
                    assertEquals(expectedShape, CanvasRenderer.getInstance().renderShape());
                });
    }

    @AfterAll
    void tearDown() {
        for (char[] array : rootshape) {
            Arrays.fill(array, ' ');
        }
    }
}
