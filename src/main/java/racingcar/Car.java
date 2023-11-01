package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int count = 0;

    Car(String tempName) {
        name = tempName;
    }

    void Racing() {
        count += camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 1);
    }
}
