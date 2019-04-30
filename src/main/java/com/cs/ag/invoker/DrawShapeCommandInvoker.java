package com.cs.ag.invoker;
/**
 * This class is responsible for executing the command from the client. This will be provided a
 * command instance with execute method.
 */
import com.cs.ag.command.DrawShape;

import java.util.ArrayList;
import java.util.List;

public class DrawShapeCommandInvoker {

    private final List<DrawShape> commands = new ArrayList<>();

    public void drawShape(DrawShape drawShape) throws Exception {
        commands.add(drawShape);
        drawShape.execute();
    }
}
