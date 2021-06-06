package personal.battleship;

import java.util.List;

public class Game {
    public boolean checkGrid(List<List<Character>> grid, String input, String name, int length) {
        String[] inputs = input.split("\\s");
        int row1 = parse(inputs[0]);
        int col1 = parse(inputs[1]);
        int row2 = parse(inputs[2]);
        int col2 = parse(inputs[3]);

        if (!isOk(row1, col1, row2, col2, name, length)) {
            return false;
        }
        if (col1 - col2 > 0) {
            col1 = getItself(col2, col2 = col1);
        }
        if (row1 - row2 > 0) {
            row1 = getItself(row2, row2 = row1);
        }
        if (isOccupied(grid, row1, col1, row2, col2)) {
            return false;
        }
        if (row1 == row2) {
            addRow(grid, col1, col2, row1);
            return true;
        }
        addCol(grid, row1, row2, col1);
        return true;
    }

    private void addRow(List<List<Character>> grid, int pos1, int pos2, int pos) {
        for (int col = pos1; col <= pos2; col++) {
            grid.get(pos).set(col, 'O');
        }
    }

    private void addCol(List<List<Character>> grid, int pos1, int pos2, int pos) {
        for (int col = pos1; col <= pos2; col++) {
            grid.get(col).set(pos, 'O');
        }
    }


    public int getItself(int itself, int dummy) {
        return itself;
    }

    private boolean isOk(int row1, int col1, int row2, int col2, String name, int length) {
        if (!wrongLocation(row1, col1, row2, col2)) {
            return false;
        }
        if (checkShipLength(length, row1, col1, row2, col2)) {
            System.out.println("Error! Wrong length of the " + name + "! Try again:");
            return false;

        }

        return true;
    }

    private boolean checkShipLength(int length, int row1, int col1, int row2, int col2) {
        return getCells(row1, col1, row2, col2) + 1 != length;
    }

    /*Start Getting total Cells*/
    private int getCells(int row1, int col1, int row2, int col2) {
        if (row1 == row2) {
            return Math.abs(col2 - col1);
        }
        return Math.abs(row2 - row1);
    }

    /*Ended Get total Cells*/

    /*Start checking location*/
    private boolean wrongLocation(int row1, int col1, int row2, int col2) {
        if (row1 != row2 && col1 != col2) {
            System.out.println("Error! Wrong ship location! Try again:");
            return false;
        }
        return true;
    }
    /*Ended checking location*/

    /*Start checking valid place*/
    private boolean isOccupied(List<List<Character>> list, int row1, int col1, int row2, int col2) {
        for (int row = row1-1; row <= row2+1; row++) {
            for (int col = col1-1; col <= col2+1; col++) {
                if (list.get(row).get(col) == 'O') {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    return true;
                }
            }
        }
        return false;
    }
    /*Ended check valid place*/

    private int parse(String input) {
        return Integer.parseInt(input);
    }
}

class GameTest {
    /*Start Checking Range*/
  /*  private boolean outOfRange(int row1, int col1, int row2, int col2) {
        return checkRange(row1) || checkRange(col1) ||
                checkRange(row2) || checkRange(col2);
    }

    private boolean checkRange(int pos) {
        return pos <= 0 || pos >= 11;
    }*/
    /*Ended Check Range*/
   /*  for (int row = row1; row <= row2; row++) {
            for (int col = col1; col <= col2; col++) {

            }
        }*/
}
