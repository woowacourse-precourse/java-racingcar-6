package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {

    public String name;
    public Integer location;

    public Car(String carName) {
        name = carName;
        location = 0;
    }

    public void tryMove() {

        if (pickNumberInRange(0, 9) >= 4) {
            location += 1;
        }
    }
}
