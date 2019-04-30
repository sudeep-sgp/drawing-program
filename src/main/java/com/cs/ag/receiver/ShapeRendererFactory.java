package com.cs.ag.receiver;
/**
 *
 * This class used for serving the receivers instances upon request.
 *
 *
 * */
import com.cs.ag.constant.CommandConstants;
import com.cs.ag.validator.CommandValidator;

public class ShapeRendererFactory {

    public ShapeRendererFactory() {}

    /**
     * @param commandArr
     * @return
     */
    public static ShapeRenderer getShapeRenderer(String[] commandArr) {

        try {

            CommandConstants mainCommand = CommandConstants.valueOf(commandArr[0].toUpperCase());

            switch (mainCommand) {
                case C:
                    CommandValidator.validateCanvasCommand(commandArr);
                    ShapeRenderer canvas =
                            CanvasRenderer.initCanvas(
                                    Integer.parseInt(commandArr[1]),
                                    Integer.parseInt(commandArr[2]));
                    return canvas;

                case L:
                    commonPreparationForValidation("L", commandArr);
                    return new LineRenderer(
                            Integer.parseInt(commandArr[1]),
                            Integer.parseInt(commandArr[2]),
                            Integer.parseInt(commandArr[3]),
                            Integer.parseInt(commandArr[4]));
                case R:
                    commonPreparationForValidation("R", commandArr);
                    return new RectangleRenderer(
                            Integer.parseInt(commandArr[1]),
                            Integer.parseInt(commandArr[2]),
                            Integer.parseInt(commandArr[3]),
                            Integer.parseInt(commandArr[4]));
                case B:
                    commonPreparationForValidation("B", commandArr);
                    return new FillRenderer(
                            Integer.parseInt(commandArr[1]),
                            Integer.parseInt(commandArr[2]),
                            commandArr[3]);
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                    "|*** Please try again, Invalid command: " + e.getMessage() + " ***|");
        } catch (Exception e) {
            System.out.println(
                    "|*** Please try again, Exception occured: " + e.getMessage() + " ***|");
        }

        return null;
    }

    /**
     * @param commandType
     * @param commands
     * @throws Exception
     */
    private static void commonPreparationForValidation(String commandType, String... commands)
            throws Exception {
        ShapeRenderer canvas;
        char[][] rootShape;
        int canvasWidth;
        int canvasHeight;
        canvas = CanvasRenderer.getInstance();
        rootShape = canvas.getRootShape();
        canvasWidth = rootShape[0].length;
        canvasHeight = rootShape.length;
        CommandValidator.validateCanvasCreation(rootShape);

        if (commandType.equals("L") || commandType.equals("R")) {
            CommandValidator.validateLineOrRectangleCommand(commands, canvasWidth, canvasHeight);
        } else {
            CommandValidator.validateFillCommand(commands, canvasWidth, canvasHeight);
        }
    }
}
