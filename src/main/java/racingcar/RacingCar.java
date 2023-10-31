package racingcar;

public class RacingCar {

    private static final int STANDARD = 4;

    private String name;
    private int advance;

    public RacingCar(String carName) {
        name = carName;
        advance = 0;
    }

    public boolean canMove(int moveNum) {
        return moveNum >= STANDARD;
    }

    public void move(int moveNum) {
        if (canMove(moveNum)) {
            advance++;
        }
    }

    public Result makeResult() {
        return new Result(name, advance);
    }
}
