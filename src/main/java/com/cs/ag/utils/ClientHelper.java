package com.cs.ag.utils;

import com.cs.ag.validator.CommandValidator;

import static com.cs.ag.constant.HelpConstants.*;

public class ClientHelper {

    /**
     * @param command
     * @return
     */
    public static String[] decodeCommand(String command) {
        CommandValidator.validateInitialCommand(command);
        String[] decodedCmdArr = null;
        String cleanedCommand = null;
        cleanedCommand = command.trim().replaceAll(" {2}", " ");
        decodedCmdArr = cleanedCommand.split(" ");
        return decodedCmdArr;
    }

    /** @param helpCommands */
    public static void printHelp(String[] helpCommands) {
        String helpMsg = "";
        if (helpCommands[0].equalsIgnoreCase("H")) {
            if (helpCommands[1].equalsIgnoreCase("C")) {
                helpMsg = CANVAS_COMMAND_HELP;
            } else if (helpCommands[1].equalsIgnoreCase("L")) {
                helpMsg = LINE_COMMAND_HELP;
            } else if (helpCommands[1].equalsIgnoreCase("R")) {
                helpMsg = RECTANGLE_COMMAND_HELP;
            } else if (helpCommands[1].equalsIgnoreCase("F")) {
                helpMsg = FILL_COMMAND_HELP;
            } else {
                helpMsg = "|**** Help command not found, Please try again ****|";
            }
            System.out.println(helpMsg);
        }
    }
}
