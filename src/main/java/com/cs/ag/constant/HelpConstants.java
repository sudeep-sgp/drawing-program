package com.cs.ag.constant;

public class HelpConstants {

    public static final String COMMAND_INTRODUCTION =
            "+---------------------------------------------------------+\n"
                    + "|                    Drawing Program                      |\n"
                    + "+---------------------------------------------------------+\n"
                    + "|  Select a Command :                                     |\n"
                    + "|  ........................................               |\n"
                    + "|  : a] C w h              Create Canvas  :               |\n"
                    + "|  : b] L x1 y1 x2 y2      Draw Line      :               |\n"
                    + "|  : c] R x1 y1 x2 y2      Draw Rectangle :               |\n"
                    + "|  : d] B x1 y1 color      Fill Color     :               |\n"
                    + "|  : e] Q                  Quit           :               |\n"
                    + "|  ........................................               |\n"
                    + "|                                                         |\n"
                    + "+---------------------------------------------------------+\n"
                    + "| For help, Enter : H [Command] ~ eg. for Canvas: H C ~   |\n"
                    + "+---------------------------------------------------------+\n";

    public static final String CANVAS_COMMAND_HELP =
            "+-------------------------------------------------------------+\n"
                    + "|C w h  [ Should create a new canvas of width w and height h].|\n"
                    + "+-------------------------------------------------------------+\n";
    public static final String LINE_COMMAND_HELP =
            "+--------------------------------------------------------------------------------+\n"
                    + "|L x1 y1 x2 y2   [ Should create a new line from (x1,y1) to (x2,y2). Currently : |\n"
                    + "|                : only horizontal or vertical lines are supported. Horizontal : |\n"
                    + "|                : and vertical lines will be drawn using the 'x' character.   ] |\n"
                    + "+--------------------------------------------------------------------------------+\n";
    public static final String RECTANGLE_COMMAND_HELP =
            "+--------------------------------------------------------------------------------+\n"
                    + "|L x1 y1 x2 y2   [ Should create a new rectangle, whose upper left corner is :   |\n"
                    + "|                : (x1,y1) and lower right corner is (x2,y2). Horizontal and :   |\n"
                    + "|                : vertical lines will be drawn using the 'x' character.     ]   |\n"
                    + "+--------------------------------------------------------------------------------+\n";
    public static final String FILL_COMMAND_HELP =
            "+--------------------------------------------------------------------------------+\n"
                    + "|B x y c        [ Should fill the entire area connected to (x,y) with :          |\n"
                    + "|               : \"colour\" c. The behaviour of this is the same as  :          |\n"
                    + "|               : that  of the \"bucket fill\" tool in paint programs ]          |\n"
                    + "+--------------------------------------------------------------------------------+\n";
}
