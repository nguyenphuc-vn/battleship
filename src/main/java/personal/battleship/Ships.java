package personal.battleship;

public enum Ships {
    AIRCRAFT("Aircraft Carrier",5),
    BATTLESHIP("Battleship ",4),
    SUBMARINE("Submarine",3),
    CRUISER("Cruiser",3),
    DESTROYER("Destroyer",2);

    private final String name ;
    private final int value;

     Ships(String name, int value){
        this.name = name;
        this.value = value;
    }
    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
