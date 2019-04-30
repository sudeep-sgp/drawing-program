package com.cs.ag.constant;

public class ValidationConstants {
    public static final String CANVAS_CREATION_CHECK =
            "Please create a canvas; eg. command : [ C 20 6 ]";
    public static final String MIN_PARAMETER_MSG =
            "Please enter minimum %d params for creating a %s";
    public static final String PARAMETER_MUST_NATURAL_NUMBER =
            "Parameters must be natural numbers ";
    public static final String PARAMETER_MUST_INTEGER = "Parameters must be integers";
    public static final String PARAMETER_WITHIN_CANVAS_BOUNDARY =
            "Parameters must be within canvas boundary [x > 0, x < %d  and y > 0, y < %d";
    public static final String PARAMETER_WITHIN_CANVAS_BOUNDARY_LR_H =
            "Something wrong!, Either x1: %d may less than 1 or x2: %d may higher than canvas width: %d";
    public static final String ARG_COUNT_LESS_THAN_EXPECTED =
            "Arguments missing, please try again.";
    public static final String COMMAND_SHOULD_NOT_EMPTY =
            "Command should not be empty, please try again.";
    public static final String COMMAND_NOT_FOUND = "Command '%s' Not found, please try again";
    public static final String PARAMETER_WITHIN_CANVAS_BOUNDARY_LR_V =
            "Something wrong!, Either y1: %d may less than 1 or y2: %d may higher than canvas height: %d";
    public static final String Y1_Y2_SHOULD_NOT_BE_EQUAL_TO_X2_Y2 =
            "Not allowed to be, x1:%d equal to x2:%d and y1:%d equal to y2:%d at the same time , please try again";
    public static final String RECTANGLE_VALIDATION_MSG =
            "The value of x1:%d should not be higher than x2:%d or the value of y1:%d should not be higher than y2:%d, please try to create the %s again";
}
