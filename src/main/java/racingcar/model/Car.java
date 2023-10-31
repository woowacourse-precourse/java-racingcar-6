package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.request.CarName;

public class Car {

    private static final Integer MIN_RANGE_NUMBER = 0;
    private static final Integer MAX_RANGE_NUMBER = 9;
    private static final Integer FORWARD_STANDARD_NUMBER = 4;

    private final String name;
    private Integer moveCount;

    public Car(CarName name) {
        this.name = name.getName();
        this.moveCount = 0;
    }

    public void randomGoForward() {
        if (isGoForward()) {
            moveCount++;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getMoveCount() {
        return moveCount;
    }

    private Boolean isGoForward() {
        return Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER)
            >= FORWARD_STANDARD_NUMBER;
    }
}
