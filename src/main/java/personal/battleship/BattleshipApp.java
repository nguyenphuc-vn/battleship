package personal.battleship;

import java.util.List;
import java.util.Scanner;

public class BattleshipApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static Game game;
    private static Engine engine;

    public static void main(String[] args) {
        engine = new Engine();
        game = new Game();
        List<List> grid = engine.getGrid();

        engine.printGrid(grid);
        askUser(grid);
    }

    private static void askUser(List<List> grid) {
        List<List> gridState = engine.getGridState();
        int enumLen = Ships.values().length;
        String input ;
        for (int i = 0; i < enumLen; i++) {
            String name = Ships.values()[i].getName();
            int cell = Ships.values()[i].getValue();
            while (true) {
                System.out.println("Enter the coordinates of the " + name +
                        " (" + cell + " cells):");
                input = scanner.nextLine().toUpperCase();
                input = engine.parseTwo(input);
                if (game.checkGrid(grid, input, name, cell)) {
                    engine.printGrid(grid);
                    break;
                }
            }
        }
        System.out.println("\nThe game starts!");
        engine.printGrid(gridState);
        input =  shotPos();
        game.placeSymbol(grid,input,engine,gridState);
    }

    private static String shotPos() {
        System.out.println("Take a shot!");
        String input = scanner.nextLine().toUpperCase();
        input = engine.parseOne(input);
        while (!engine.checkShotPosition(input)) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            input = scanner.nextLine().toUpperCase();
            if(!engine.checkRange(input)){
                continue;
            }
            input = engine.parseOne(input);

        }
        return input;
    }
}

