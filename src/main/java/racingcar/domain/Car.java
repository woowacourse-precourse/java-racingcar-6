package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Car {
    private Name name;
    private Move move;

    Set<String> carNames = new HashSet<>();

    public Car(String carName) {
        validateDuplicatedName(carName);
        validateNameLength(carName);
        this.name = new Name(carName);
        this.move = new Move();
        carNames.add(carName);
    }

    public void moveForward() {
        if (generateRandomNumber() >= 4) {
            move.increase();
        }
    }

    public int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

    private void validateDuplicatedName(String carName) {
        if (isNameDuplicated(carName)) {
            throw new IllegalArgumentException("이미 사용중인 자동차 이름입니다.");
        }
    }

    private boolean isNameDuplicated(String carName) {
        return carNames.contains(carName);
    }

    private void validateNameLength(String carName) {
        if (isNameTooLong(carName)) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다");
        }
    }

    private boolean isNameTooLong(String carName) {
        return carName.length() > 5;
    }
}
