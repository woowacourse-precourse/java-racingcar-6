package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    String name;
    int position = 0;

    public Car (String name, int position) {
        if (name.length() > 5)
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        this.name = name;
        this.position = position;
    }
    public void moveCar() {
        if (pickNumberInRange(0, 9) >= 4)
            this.position++;
    }
}