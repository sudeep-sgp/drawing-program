package com.cs.ag;

/***
 * Copyright (c) 2019, Sudeep P.G, sudeeppg@yahoo.com All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 ***/

import com.cs.ag.command.*;
import com.cs.ag.invoker.DrawShapeCommandInvoker;
import com.cs.ag.receiver.ShapeRenderer;
import com.cs.ag.receiver.ShapeRendererFactory;
import com.cs.ag.utils.ClientHelper;
import com.cs.ag.validator.CommandValidator;

import java.util.Scanner;

import static com.cs.ag.constant.HelpConstants.COMMAND_INTRODUCTION;
import static com.cs.ag.utils.ClientHelper.printHelp;

public class App {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        String cmdLineInput = new String();
        System.out.println(COMMAND_INTRODUCTION);
        while (!cmdLineInput.equalsIgnoreCase("Q")) {
            System.out.println("\nPlease enter the command: ");
            cmdLineInput = processController(cmdLineInput);
        }
        quit();
    }

    private static String processController(String cmdLineInput) {
        String[] commandAndParams;
        String command;
        ShapeRenderer shapeRenderer;
        DrawShape drawShapeCmd;
        try {
            cmdLineInput = scanner.nextLine();
            commandAndParams = ClientHelper.decodeCommand(cmdLineInput);
            command = commandAndParams[0].toUpperCase();
            if ("H".equalsIgnoreCase(command)) {
                printHelp(commandAndParams);
            } else {
                CommandValidator.validateAllCommands(commandAndParams);
                DrawShapeCommandInvoker invoker = new DrawShapeCommandInvoker();

                /** ** CanvasRenderer action *** */
                if ("C".equalsIgnoreCase(command)) {
                    shapeRenderer = ShapeRendererFactory.getShapeRenderer(commandAndParams);
                    drawShapeCmd = new DrawCanvas(shapeRenderer);
                    invoker.drawShape(drawShapeCmd::execute);
                }
                /** ** LineRenderer action *** */
                else if ("L".equalsIgnoreCase(command)) {
                    shapeRenderer = ShapeRendererFactory.getShapeRenderer(commandAndParams);
                    drawShapeCmd = new DrawLine(shapeRenderer);
                    invoker.drawShape(drawShapeCmd::execute);
                }
                /** ** Rectangular action *** */
                else if ("R".equalsIgnoreCase(command)) {
                    shapeRenderer = ShapeRendererFactory.getShapeRenderer(commandAndParams);
                    drawShapeCmd = new DrawRectangle(shapeRenderer);
                    invoker.drawShape(drawShapeCmd::execute);
                }
                /** ** Rectangular action *** */
                else if ("B".equalsIgnoreCase(command)) {
                    shapeRenderer = ShapeRendererFactory.getShapeRenderer(commandAndParams);
                    drawShapeCmd = new DrawFill(shapeRenderer);
                    invoker.drawShape(drawShapeCmd::execute);
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("|*** " + e.getMessage() + " ***|");

        } catch (Exception e) {
            System.out.println("|*** " + e.getMessage() + " ***|");
        }
        return cmdLineInput;
    }

    private static void quit() {
        System.out.println("Quiting ...");
        scanner.close();
        System.exit(0);
    }
}
