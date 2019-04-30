package com.cs.ag.validator;

import com.cs.ag.constant.ValidationConstants;
import com.cs.ag.exception.CommandNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.cs.ag.constant.TestConstant.*;
import static com.cs.ag.constant.ValidationConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class CommandValidatorTest {

    String[] commands;

    @BeforeEach
    void setUp() {}

    @AfterEach
    void tearDown() {}

    @Test
    void validateCanvasCommandTest() {
        assumingThat(
                COMMAND_C_TO_FAIL_VALIDATION_FOR_NON_NUMBER[0].equalsIgnoreCase("C"),
                () -> {
                    Exception exception =
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () ->
                                            CommandValidator.validateCanvasCommand(
                                                    COMMAND_C_TO_FAIL_VALIDATION_FOR_NON_NUMBER));
                    assertEquals(
                            ValidationConstants.PARAMETER_MUST_INTEGER, exception.getMessage());
                });

        assumingThat(
                COMMAND_C_TO_FAIL_VALIDATION_FOR_NEGATIVE_NUMBER[0].equalsIgnoreCase("C"),
                () -> {
                    Exception exception =
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () ->
                                            CommandValidator.validateCanvasCommand(
                                                    COMMAND_C_TO_FAIL_VALIDATION_FOR_NEGATIVE_NUMBER));
                    assertEquals(PARAMETER_MUST_NATURAL_NUMBER, exception.getMessage());
                });
    }

    @Test
    void validateLineOrRectangleCommandTest() {
        assumingThat(
                COMMAND_L_R_TO_FAIL_VALIDATION_FOR_CANVAS_V_BOUNDARY[0].equalsIgnoreCase("R"),
                () -> {
                    Exception exception =
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () ->
                                            CommandValidator.validateLineOrRectangleCommand(
                                                    COMMAND_L_R_TO_FAIL_VALIDATION_FOR_CANVAS_V_BOUNDARY,
                                                    CANVAS_WIDTH,
                                                    CANVAS_HEIGHT));
                    assertEquals(
                            String.format(
                                    PARAMETER_WITHIN_CANVAS_BOUNDARY_LR_V,
                                    Integer.parseInt(
                                            COMMAND_L_R_TO_FAIL_VALIDATION_FOR_CANVAS_V_BOUNDARY[
                                                    2]),
                                    Integer.parseInt(
                                            COMMAND_L_R_TO_FAIL_VALIDATION_FOR_CANVAS_V_BOUNDARY[
                                                    4]),
                                    CANVAS_HEIGHT),
                            exception.getMessage());
                });

        assumingThat(
                COMMAND_L_R_TO_FAIL_VALIDATION_FOR_CANVAS_H_BOUNDARY[0].equalsIgnoreCase("R"),
                () -> {
                    Exception exception =
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () ->
                                            CommandValidator.validateLineOrRectangleCommand(
                                                    COMMAND_L_R_TO_FAIL_VALIDATION_FOR_CANVAS_H_BOUNDARY,
                                                    CANVAS_WIDTH,
                                                    CANVAS_HEIGHT));
                    assertEquals(
                            String.format(
                                    PARAMETER_WITHIN_CANVAS_BOUNDARY_LR_H,
                                    Integer.parseInt(
                                            COMMAND_L_R_TO_FAIL_VALIDATION_FOR_CANVAS_H_BOUNDARY[
                                                    1]),
                                    Integer.parseInt(
                                            COMMAND_L_R_TO_FAIL_VALIDATION_FOR_CANVAS_H_BOUNDARY[
                                                    3]),
                                    CANVAS_WIDTH),
                            exception.getMessage());
                });

        assumingThat(
                COMMAND_L_R_TO_FAIL_VALIDATION_FOR_EQUAL_CHECK[0].equalsIgnoreCase("R")
                        || COMMAND_L_R_TO_FAIL_VALIDATION_FOR_EQUAL_CHECK[0].equalsIgnoreCase("L"),
                () -> {
                    Exception exception =
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () ->
                                            CommandValidator.validateLineOrRectangleCommand(
                                                    COMMAND_L_R_TO_FAIL_VALIDATION_FOR_EQUAL_CHECK,
                                                    CANVAS_WIDTH,
                                                    CANVAS_HEIGHT));
                    assertEquals(
                            String.format(
                                    Y1_Y2_SHOULD_NOT_BE_EQUAL_TO_X2_Y2,
                                    Integer.parseInt(
                                            COMMAND_L_R_TO_FAIL_VALIDATION_FOR_EQUAL_CHECK[1]),
                                    Integer.parseInt(
                                            COMMAND_L_R_TO_FAIL_VALIDATION_FOR_EQUAL_CHECK[3]),
                                    Integer.parseInt(
                                            COMMAND_L_R_TO_FAIL_VALIDATION_FOR_EQUAL_CHECK[2]),
                                    Integer.parseInt(
                                            COMMAND_L_R_TO_FAIL_VALIDATION_FOR_EQUAL_CHECK[4])),
                            exception.getMessage());
                });

        assumingThat(
                COMMAND_L_R_TO_FAIL_VALIDATION_FOR_X1_Y1_HIGHER_THAN_X2_Y2[0].equalsIgnoreCase("R"),
                () -> {
                    Exception exception =
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () ->
                                            CommandValidator.validateLineOrRectangleCommand(
                                                    COMMAND_L_R_TO_FAIL_VALIDATION_FOR_X1_Y1_HIGHER_THAN_X2_Y2,
                                                    CANVAS_WIDTH,
                                                    CANVAS_HEIGHT));
                    assertEquals(
                            String.format(
                                    RECTANGLE_VALIDATION_MSG,
                                    Integer.parseInt(
                                            COMMAND_L_R_TO_FAIL_VALIDATION_FOR_X1_Y1_HIGHER_THAN_X2_Y2[
                                                    1]),
                                    Integer.parseInt(
                                            COMMAND_L_R_TO_FAIL_VALIDATION_FOR_X1_Y1_HIGHER_THAN_X2_Y2[
                                                    3]),
                                    Integer.parseInt(
                                            COMMAND_L_R_TO_FAIL_VALIDATION_FOR_X1_Y1_HIGHER_THAN_X2_Y2[
                                                    2]),
                                    Integer.parseInt(
                                            COMMAND_L_R_TO_FAIL_VALIDATION_FOR_X1_Y1_HIGHER_THAN_X2_Y2[
                                                    4]),
                                    "RECTANGLE"),
                            exception.getMessage());
                });
    }

    @Test
    void validateCanvasCreationTest() {}

    @Test
    void validateInitialCommandTest() {}

    /** */
    @Test
    void validateAllCommandsTest() {
        assumingThat(
                COMMAND_TO_FAIL_VALIDATION_FOR_MIN_ARG.length < 3,
                () -> {
                    Exception exception =
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () ->
                                            CommandValidator.validateAllCommands(
                                                    COMMAND_TO_FAIL_VALIDATION_FOR_MIN_ARG));
                    assertEquals(ARG_COUNT_LESS_THAN_EXPECTED, exception.getMessage());
                });

        assumingThat(
                COMMAND_TO_FAIL_VALIDATION_EMPTY_ARG == null,
                () -> {
                    Exception exception =
                            assertThrows(
                                    NullPointerException.class,
                                    () ->
                                            CommandValidator.validateAllCommands(
                                                    COMMAND_TO_FAIL_VALIDATION_EMPTY_ARG));
                    assertEquals(COMMAND_SHOULD_NOT_EMPTY, exception.getMessage());
                });

        assumingThat(
                !COMMAND_TO_FAIL_VALIDATION_FOR_UNKNOWN_COMMAND[0].equalsIgnoreCase("Q"),
                () -> {
                    Exception exception =
                            assertThrows(
                                    CommandNotFoundException.class,
                                    () ->
                                            CommandValidator.validateAllCommands(
                                                    COMMAND_TO_FAIL_VALIDATION_FOR_UNKNOWN_COMMAND));
                    assertEquals(
                            String.format(
                                    COMMAND_NOT_FOUND,
                                    COMMAND_TO_FAIL_VALIDATION_FOR_UNKNOWN_COMMAND[0]),
                            exception.getMessage());
                });
    }

    @Test
    void validateFillCommandTest() {
        assumingThat(
                COMMAND_TO_FAIL_VALIDATION_FOR_MIN_ARG_F[0].equalsIgnoreCase("F"),
                () -> {
                    Exception exception =
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () ->
                                            CommandValidator.validateFillCommand(
                                                    COMMAND_TO_FAIL_VALIDATION_FOR_MIN_ARG_F,
                                                    CANVAS_WIDTH,
                                                    CANVAS_HEIGHT));
                    assertEquals(
                            String.format(MIN_PARAMETER_MSG, 3, "FILL"), exception.getMessage());
                });

        assumingThat(
                COMMAND_C_TO_FAIL_VALIDATION_FOR_NON_NUMBER_F[0].equalsIgnoreCase("F"),
                () -> {
                    Exception exception =
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () ->
                                            CommandValidator.validateFillCommand(
                                                    COMMAND_C_TO_FAIL_VALIDATION_FOR_NON_NUMBER_F,
                                                    CANVAS_WIDTH,
                                                    CANVAS_HEIGHT));
                    assertEquals(
                            ValidationConstants.PARAMETER_MUST_INTEGER, exception.getMessage());
                });

        assumingThat(
                COMMAND_C_TO_FAIL_VALIDATION_FOR_CANVAS_BOUNDARY_F[0].equalsIgnoreCase("F"),
                () -> {
                    Exception exception =
                            assertThrows(
                                    IllegalArgumentException.class,
                                    () ->
                                            CommandValidator.validateFillCommand(
                                                    COMMAND_C_TO_FAIL_VALIDATION_FOR_CANVAS_BOUNDARY_F,
                                                    CANVAS_WIDTH,
                                                    CANVAS_HEIGHT));
                    assertEquals(
                            String.format(
                                    PARAMETER_WITHIN_CANVAS_BOUNDARY, CANVAS_WIDTH, CANVAS_HEIGHT),
                            exception.getMessage());
                });
    }
}
