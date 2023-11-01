package racingcar;

public class RacingCar {
    private final String name;
    private int moved;

    public RacingCar(String name, int moved) {
        this.name = name;
        this.moved = moved;
    }

    public String getName() {
        return name;
    }

    public int getMoved(){
        return moved;
    }
}
