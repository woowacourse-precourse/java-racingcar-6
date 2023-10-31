package racingcar;

public class RacingCar {

    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public boolean moveBy(int random) {
        if (random > 4) {
            position++;
            return true;
        }
        return false;
    }
}
