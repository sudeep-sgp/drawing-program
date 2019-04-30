package com.cs.ag.constant;

public class TestConstant {
    public static final String CANVAS_EXPECTED_RESULT =
            "----------------------\n"
                    + "|                    |\n"
                    + "|                    |\n"
                    + "|                    |\n"
                    + "|                    |\n"
                    + "----------------------";
    public static final String LINE_EXPECTED_SINGLE_RESULT =
            "----------------------\n"
                    + "|                    |\n"
                    + "|xxxxxx              |\n"
                    + "|                    |\n"
                    + "|                    |\n"
                    + "----------------------";
    public static final String LINE_EXPECTED_JOINED_RESULT =
            "----------------------\n"
                    + "|                    |\n"
                    + "|xxxxxx              |\n"
                    + "|     x              |\n"
                    + "|     x              |\n"
                    + "----------------------";
    public static final String RECTANGLE_EXPECTED_SINGLE_RESULT =
            "----------------------\n"
                    + "|             xxxxx  |\n"
                    + "|             x   x  |\n"
                    + "|             xxxxx  |\n"
                    + "|                    |\n"
                    + "----------------------";
    public static final String RECTANGLE_EXPECTED_JOINED_RESULT =
            "----------------------\n"
                    + "|             xxxxx  |\n"
                    + "|xxxxxx       x   x  |\n"
                    + "|     x       xxxxx  |\n"
                    + "|     x              |\n"
                    + "----------------------";
    public static final String FILL_EXPECTED_SINGLE_RESULT =
            "----------------------\n"
                    + "|oooooooooo          |\n"
                    + "|oooooooooo          |\n"
                    + "|oooooooooo          |\n"
                    + "|oooooooooo          |\n"
                    + "----------------------";
    public static final String FILL_EXPECTED_JOINED_RESULT =
            "----------------------\n"
                    + "|oooooooooo   xxxxx  |\n"
                    + "|xxxxxxoooo   x   x  |\n"
                    + "|     xoooo   xxxxx  |\n"
                    + "|     xoooo          |\n"
                    + "----------------------";
    public static final String[] COMMAND_TO_FAIL_VALIDATION_FOR_MIN_ARG = {"C", "1"};
    public static final String[] COMMAND_TO_FAIL_VALIDATION_EMPTY_ARG = null;
    public static final String[] COMMAND_TO_FAIL_VALIDATION_FOR_UNKNOWN_COMMAND = {"K", "3", "4"};
    public static final String[] COMMAND_C_TO_FAIL_VALIDATION_FOR_NON_NUMBER = {"C", "a", "4"};
    public static final String[] COMMAND_C_TO_FAIL_VALIDATION_FOR_NEGATIVE_NUMBER = {
        "C", "-1", "4"
    };
    public static final int CANVAS_WIDTH = 22;
    public static final int CANVAS_HEIGHT = 6;
    public static final String[] COMMAND_L_R_TO_FAIL_VALIDATION_FOR_CANVAS_V_BOUNDARY = {
        "R", "2", "0", "7", "7"
    };
    public static final String[] COMMAND_L_R_TO_FAIL_VALIDATION_FOR_CANVAS_H_BOUNDARY = {
        "R", "0", "3", "23", "4"
    };
    public static final String[] COMMAND_L_R_TO_FAIL_VALIDATION_FOR_EQUAL_CHECK = {
        "L", "2", "4", "2", "4"
    };
    public static final String[] COMMAND_L_R_TO_FAIL_VALIDATION_FOR_X1_Y1_HIGHER_THAN_X2_Y2 = {
        "R", "5", "4", "1", "4"
    };
    public static final String[] COMMAND_C_TO_FAIL_VALIDATION_FOR_NON_NUMBER_F = {
        "F", "a", "4", "O"
    };
    public static final String[] COMMAND_C_TO_FAIL_VALIDATION_FOR_CANVAS_BOUNDARY_F = {
        "F", "23", "8", "O"
    };
    public static final String[] COMMAND_TO_FAIL_VALIDATION_FOR_MIN_ARG_F = {"F", "5", "3"};
}
