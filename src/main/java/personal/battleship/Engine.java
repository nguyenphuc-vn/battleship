package personal.battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* Step 1: print grid 10x10
   Step 2 : Place coordinates

 O one of the cell ship
 x is part of ship was hit
 M is missing hit
 Aircraft Carrier is 5 cells
 Battleship is 4 cells
 Submarine && Cruiser  is 3 cells
 Destroyer is 2 cells
 -- Largest one first
 -- Input : String : F3 F7
 -- If out of range -> error
 -- If occupied --> error
 -- If wrong length --> error
-----------------------------------
Take input
check valid place --loop
Check if it hit ship
---> hit
---> missed

 */
public class Engine {
    private final List<List> grid;
    private final List<List> gridState;

    public Engine() {
        this.grid = new ArrayList<>();
        this.gridState = new ArrayList<>();
        setGrid(grid);
        setGrid(gridState);
    }

    public void printGrid(List<List> grid) {
        char symbol = 'A';
        for (int i = 1; i < 11; i++) {
            System.out.print(" " + i);
        }
        for (int row = 1; row < 11; row++) {
            System.out.print("\n" + symbol++ + " ");
            for (int col = 1; col < 11; col++) {
                    System.out.print(grid.get(row).get(col) + " ");
            }
        }
        System.out.println();
    }

    private void setGrid(List<List> grid ) {
        for (int row = 0; row < 12; row++) {
            grid.add(new ArrayList<>(12));
            for (int col = 0; col < 12; col++) {
                 grid.get(row).add('~');
            }
        }
    }

    /*  START PARSING */
    public String parseTwo(String input) {
        String[] position = input.split("\\s");
        int first = getPosition(position[0]);
        int second = getPosition(position[1]);
        String firstAfter = replaceInput(position[0], first);
        String secondAfter = replaceInput(position[1], second);
        return firstAfter + " " + secondAfter;
    }

    private String replaceInput(String input, int place) {
        return input.replaceAll("[A-J]", place + " ");
    }
    public String parseOne(String input){
        int first = getPosition(input);
        return replaceInput(input,first);
    }
    private int getPosition(String input) {
        return input.charAt(0) - 64;
    }
    /*END PARSE INPUT*/

    /*Check shot position*/
    public boolean checkShotPosition(String input){
        return input.charAt(0)-49 >= 0 && input.charAt(0)-49 <= 10;
    }

    /*End check shot position*/
    public boolean checkRange(String input){
        Pattern pattern = Pattern.compile("[A-J][0-9]|10");
        return pattern.matcher(input).matches();

    }

    public List<List> getGrid() {
        return grid;
    }

    public List<List> getGridState() {
        return gridState;
    }
}

