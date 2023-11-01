package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.util.StringUtil.convertToString;

public class Car {
    private final String name;
    private int number;
    private int movementCount;
    private String movementForwardResult;

    public Car(
            final String name
    ) {
        this.name = name;
        setMovementCount();
        setMovementForwardResult();
    }

    public String getName() {
        return name;
    }

    public int getMovementCount() {
        return movementCount;
    }

    public String getMovementForwardResult() {
        return movementForwardResult;
    }

    public void setMovementForwardResult() {
        this.movementForwardResult = name + " : " + convertToString(movementCount);
    }

    public void setMovementCount() {
        this.movementCount++;
    }

    public void setNumber() {
        this.number = Randoms.pickNumberInRange(0, 9);
    }

    public int getNumber() {
        return number;
    }
}
