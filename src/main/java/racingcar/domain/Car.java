package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class Car {
    private final String name;
    private int forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public void forward() {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        if (isNumOverThree(pickedNumber))
            forwardCount++;
    }

    private boolean isNumOverThree(int number) {
        return number > 3;
    }
}
