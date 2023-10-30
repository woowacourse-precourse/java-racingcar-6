package racingcar;

import java.util.List;

public class RacingCarGame {
    private int moveNumber;
    private List<Car> carList;
    private final User user = new User();

    public void start() {
        carList = user.getCarNames();
        moveNumber = user.getMoveNumber();
        for (int i = 0; i < moveNumber; i++) {
            move();
        }
        printFinishCarNames();
    }

    public void move() {}

    public void printFinishCarNames() {}
}
