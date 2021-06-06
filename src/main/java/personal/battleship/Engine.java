package personal.battleship;

import java.util.ArrayList;
import java.util.List;

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

 */
public class Engine {
    private final List<List<Character>> grid;

    public Engine() {
        this.grid = new ArrayList<>();
        setGrid();
    }

    public void printGrid() {
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
    }

    private void setGrid() {
        for (int row = 0; row < 12; row++) {
            grid.add(new ArrayList<>(12));
            for (int col = 0; col < 12; col++) {
                grid.get(row).add('~');
            }
        }
    }

    /*  START PARSING */
    public String parse(String input) {
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

    private int getPosition(String input) {
        return input.charAt(0) - 64;
    }
    /*END PARSE INPUT*/

    public List<List<Character>> getGrid() {
        return grid;
    }
}

class EngineTest {
    static Engine engine = new Engine();
    static String first = "F3 F7";
    static String second = "A1 D1";
    static String third = "J7 J10";
    static String fourth = "J10 J8";
    static String fifth = "B9 D8";
    static String sixth = "B9 D9";
    static String seventh = "E6 D6";
    static String eighth = "I2 J2";
    static List<String> mockList = new ArrayList<>();

    public static void main(String[] args) {

        testSetup();
        parseTest();
    }

    private static void testSetup() {
        engine.printGrid();
    }

    /*  private static void setUp(){
          mockList.add(first);  mockList.add(second);  mockList.add(third);  mockList.add(fourth);
          mockList.add(fifth);  mockList.add(sixth);  mockList.add(seventh);  mockList.add(eighth);
      }*/
    private static void parseTest() {
        System.out.println("first " + engine.parse(first));
        System.out.println("second " + engine.parse(second));
        System.out.println("third " + engine.parse(third));
        System.out.println("fourth " + engine.parse(fourth));
        System.out.println("fifth " + engine.parse(fifth));
        System.out.println("sixth " + engine.parse(sixth));
        System.out.println("seventh " + engine.parse(seventh));
        System.out.println("eighth " + engine.parse(eighth));


    }
}