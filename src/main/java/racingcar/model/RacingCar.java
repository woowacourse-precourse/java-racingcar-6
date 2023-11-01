package racingcar.model;

import racingcar.utils.ValidationUtil;

public class RacingCar {
    private final String name;
    private int move;

    public RacingCar(String name) {
        ValidationUtil.racingCarValidator(name);
        this.name = name;
        this.move = 0;
    }

    public void plusMove(int move) {
        this.move += move;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return move;
    }
}
