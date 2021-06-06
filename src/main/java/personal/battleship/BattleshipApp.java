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
        engine.printGrid();
        askUser();
    }
    public static void askUser() {
        List<List<Character>> grid = engine.getGrid();
        int enumLen = Ships.values().length;
        for (int i = 0; i < enumLen; i++) {
            String name = Ships.values()[i].getName();
            int cell = Ships.values()[i].getValue();
            while (true) {
                System.out.println("\nEnter the coordinates of the " + name +
                        " (" + cell + " cells):");
                String input = scanner.nextLine();
                input = engine.parse(input);
                if (game.checkGrid(grid, input, name, cell)) {
                    engine.printGrid();
                    break;
                }
            }
        }
    }
}
