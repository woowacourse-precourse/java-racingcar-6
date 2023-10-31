package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String name = "이름없음";
    public int score;

    public Car(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public void moveOrStay() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            ++score;
        }
    }
}
