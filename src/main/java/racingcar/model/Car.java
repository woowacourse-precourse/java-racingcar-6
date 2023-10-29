package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.MoveResultDto;

public class Car {

    private final String name;
    private Integer location;

    private Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public static Car withName(String name) {
        return new Car(name);
    }

    public MoveResultDto move() {
        moveOrStop(generateRandomNumber());
        return MoveResultDto.make(name, location);
    }

    protected int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    protected void moveOrStop(int randomNumber) {
        if (randomNumber >= 4) {
            location++;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getLocation() {
        return location;
    }
}
