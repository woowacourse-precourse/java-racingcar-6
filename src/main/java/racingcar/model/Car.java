package racingcar.model;

import racingcar.dto.request.CarName;

public class Car {

    private static final Integer MIN_RANGE_NUMBER = 0;
    private static final Integer MAX_RANGE_NUMBER = 9;
    private static final Integer CAN_MOVE_STANDARD_NUMBER = 4;

    private final NumberGenerator numberGenerator;
    private final String name;
    private Integer moveCount;

    public Car(CarName name, NumberGenerator numberGenerator) {
        this.name = name.name();
        this.numberGenerator = numberGenerator;
        this.moveCount = 0;
    }

    public void tryMove() {
        if (canMove()) {
            moveCount++;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getMoveCount() {
        return moveCount;
    }

    private Boolean canMove() {
        return numberGenerator.generateInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER)
            >= CAN_MOVE_STANDARD_NUMBER;
    }
}
