package com.cs.ag.validator;

import com.cs.ag.constant.CommandConstants;
import com.cs.ag.constant.ValidationConstants;
import com.cs.ag.exception.CanvasNotCreatedException;
import com.cs.ag.exception.CommandNotFoundException;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.primitives.Ints;

import java.util.Arrays;

import static com.cs.ag.constant.ValidationConstants.*;

public class CommandValidator {
    /** @param commands */
    public static void validateCanvasCommand(String... commands) {
        Preconditions.checkArgument(
                commands.length > 2,
                String.format(ValidationConstants.MIN_PARAMETER_MSG, 2, "CANVAS"));
        Preconditions.checkArgument(
                (Ints.tryParse(commands[1]) != null && Ints.tryParse(commands[1]) != null),
                ValidationConstants.PARAMETER_MUST_INTEGER);
        Preconditions.checkArgument(
                (Ints.tryParse(commands[1]) > 0) && (Ints.tryParse(commands[2]) > 0),
                ValidationConstants.PARAMETER_MUST_NATURAL_NUMBER);
    }

    /**
     * @param commands
     * @param canvasWidth
     * @param canvasHeight
     */
    public static void validateLineOrRectangleCommand(
            String[] commands, int canvasWidth, int canvasHeight) {
        int x1 = Integer.parseInt(commands[1]);
        int y1 = Integer.parseInt(commands[2]);
        int x2 = Integer.parseInt(commands[3]);
        int y2 = Integer.parseInt(commands[4]);
        String commandType = commands[0].equalsIgnoreCase("L") ? "LINE" : "RECTANGLE";

        Preconditions.checkArgument(
                commands.length > 4,
                String.format(ValidationConstants.MIN_PARAMETER_MSG, 2, commandType));
        Preconditions.checkArgument(
                (Ints.tryParse(commands[1]) != null
                        && Ints.tryParse(commands[2]) != null
                        && Ints.tryParse(commands[3]) != null
                        && Ints.tryParse(commands[4]) != null),
                ValidationConstants.PARAMETER_MUST_INTEGER);
        Preconditions.checkArgument(
                (x1 > 0 && x2 < canvasWidth),
                String.format(
                        ValidationConstants.PARAMETER_WITHIN_CANVAS_BOUNDARY_LR_H,
                        x1,
                        x2,
                        canvasWidth));
        Preconditions.checkArgument(
                (y1 > 0 && y2 < canvasHeight),
                String.format(PARAMETER_WITHIN_CANVAS_BOUNDARY_LR_V, y1, y2, canvasHeight));
        Preconditions.checkArgument(
                (x1 != x2 || y1 != y2),
                String.format(Y1_Y2_SHOULD_NOT_BE_EQUAL_TO_X2_Y2, x1, x2, y1, y2));
        if (commandType.equals("RECTANGLE")) rectangleValidator(x1, y1, x2, y2);
    }

    /**
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    private static void rectangleValidator(int x1, int y1, int x2, int y2) {
        Preconditions.checkArgument(
                (x1 < x2 && y1 < y2),
                String.format(RECTANGLE_VALIDATION_MSG, x1, x2, y1, y2, "RECTANGLE"));
    }

    /**
     * @param rootShape
     * @throws Exception
     */
    public static void validateCanvasCreation(char[][] rootShape) throws Exception {
        if (rootShape == null) {

            throw new CanvasNotCreatedException(CANVAS_CREATION_CHECK);
        }
    }

    /** @param command */
    public static void validateInitialCommand(String command) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(command), COMMAND_SHOULD_NOT_EMPTY);
    }

    /** @param commands */
    public static void validateAllCommands(String... commands) {
        Preconditions.checkNotNull(commands, COMMAND_SHOULD_NOT_EMPTY);
        if (!"Q".equalsIgnoreCase(commands[0]))
            Preconditions.checkArgument(commands.length >= 3, ARG_COUNT_LESS_THAN_EXPECTED);
        CommandConstants[] commandTypes = CommandConstants.values();
        Arrays.stream(commandTypes)
                .filter(e -> e.name().equalsIgnoreCase(commands[0]))
                .findFirst()
                .orElseThrow(
                        () ->
                                new CommandNotFoundException(
                                        String.format(COMMAND_NOT_FOUND, commands[0])));
    }

    /**
     * @param commands
     * @param canvasWidth
     * @param canvasHeight
     */
    public static void validateFillCommand(String[] commands, int canvasWidth, int canvasHeight) {
        String commandType = "FILL";
        Preconditions.checkArgument(
                commands.length > 3,
                String.format(ValidationConstants.MIN_PARAMETER_MSG, 3, commandType));

        Preconditions.checkArgument(
                Ints.tryParse(commands[1]) != null && Ints.tryParse(commands[2]) != null,
                ValidationConstants.PARAMETER_MUST_INTEGER);

        Preconditions.checkArgument(
                (Integer.parseInt(commands[1]) > 0 && Integer.parseInt(commands[2]) < canvasHeight)
                        && (Integer.parseInt(commands[2]) > 0
                                && Integer.parseInt(commands[2]) < canvasHeight),
                String.format(
                        ValidationConstants.PARAMETER_WITHIN_CANVAS_BOUNDARY,
                        canvasWidth,
                        canvasHeight));
    }
}
