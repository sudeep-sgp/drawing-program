package com.cs.ag;

import com.cs.ag.command.DrawCanvasTest;
import com.cs.ag.receiver.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
    CanvasRendererTest.class,
    LineRendererTest.class,
    RectangleRendererTest.class,
    FillRendererTest.class,
    DrawCanvasTest.class,
    ShapeRendererFactoryTest.class
})
public class DrawingAppTestSuite {}
