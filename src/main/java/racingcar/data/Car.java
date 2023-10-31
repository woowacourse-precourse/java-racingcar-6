package racingcar.data;

import racingcar.util.CarUtil;

public class Car {
    private String name;
    private int moveDistance;

    public Car(String name, int moveCount) {
        this.name = name;
        this.moveDistance = moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void move(boolean isPossibleMove) {
        if (isPossibleMove) {
            moveDistance++;
        }

        String moveString = CarUtil.SHOW_MOVE_DISTANCE.repeat(moveDistance);
        CarUtil.printMoveCar(name, moveString);
    }
}
