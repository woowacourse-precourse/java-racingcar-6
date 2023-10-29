package racingcar.model;

public class RacingCar {
    private String name;
    private int move;

    public RacingCar(String name) {
        this.name = name;
        this.move = 0;
    }

    public void plusMove(int move) {
        this.move += move;
    }
}
