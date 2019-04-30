package com.cs.ag.utils;

import com.cs.ag.constant.FillerConstants;
import com.cs.ag.receiver.Point;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class ReceiverHelper {

    /**
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param shape
     * @param c
     */
    public static void constructLine(int x1, int y1, int x2, int y2, char[][] shape, char c) {

        c = c != '\u0000' ? c : FillerConstants.DEFAULT_FILLER.getFiller();
        for (int row = y1; row <= y2; row++) {
            for (int col = x1; col <= x2; col++) {
                shape[row][col] = c;
            }
        }
    }

    /**
     * @param rootShape
     * @return
     */
    public static String printShape(char[][] rootShape) {
        String shapeToPrint =
                Arrays.stream(rootShape)
                        .map(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(shapeToPrint);
        return shapeToPrint;
    }

    /** * method is based on seed fill algo ** */
    public static void floodFiller(char[][] rootShape, int x, int y, char newChar) {
        int canvasHeight = rootShape.length;
        int canvasWidth = rootShape[0].length;
        char targetChar = rootShape[y - 1][x - 1];

        if (newChar == targetChar) return;

        rootShape[y - 1][x - 1] =
                Character.isDefined(newChar) ? newChar : FillerConstants.DEFAULT_FILLER.getFiller();
        Point node = new Point(y, x);
        Queue<Point> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            if (currentPoint.getX() - 1 > 0
                    && rootShape[currentPoint.getX() - 1][currentPoint.getY()] != newChar
                    && rootShape[currentPoint.getX() - 1][currentPoint.getY()] == targetChar) {
                node = new Point(currentPoint.getX() - 1, currentPoint.getY());
                queue.add(node);
                rootShape[currentPoint.getX() - 1][currentPoint.getY()] = newChar;
            }
            if (currentPoint.getX() + 1 < canvasWidth
                    && rootShape[currentPoint.getX() + 1][currentPoint.getY()] != newChar
                    && rootShape[currentPoint.getX() + 1][currentPoint.getY()] == targetChar) {
                node = new Point(currentPoint.getX() + 1, currentPoint.getY());
                queue.add(node);
                rootShape[currentPoint.getX() + 1][currentPoint.getY()] = newChar;
            }
            if (currentPoint.getY() - 1 > 0
                    && rootShape[currentPoint.getX()][currentPoint.getY() - 1] != newChar
                    && rootShape[currentPoint.getX()][currentPoint.getY() - 1] == targetChar) {
                node = new Point(currentPoint.getX(), currentPoint.getY() - 1);
                queue.add(node);
                rootShape[currentPoint.getX()][currentPoint.getY() - 1] = newChar;
            }
            if (currentPoint.getY() + 1 < canvasHeight
                    && rootShape[currentPoint.getX()][currentPoint.getY() + 1] != newChar
                    && rootShape[currentPoint.getX()][currentPoint.getY() + 1] == targetChar) {
                node = new Point(currentPoint.getX(), currentPoint.getY() + 1);
                queue.add(node);
                rootShape[currentPoint.getX()][currentPoint.getY() + 1] = newChar;
            }
        }
    }
}
