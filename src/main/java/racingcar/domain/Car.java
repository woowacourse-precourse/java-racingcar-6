package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;  //refactor final
    private String position;

    public Car(String name) {
        this.name = name;
        position = "";
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            position += "-";
        }
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
