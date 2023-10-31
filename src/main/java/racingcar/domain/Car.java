package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private Name name;
    private Move move;

    public Car(String carName) {
        validateNameLength(carName);
        validateCarNameEmpty(carName);
        this.name = new Name(carName);
        this.move = new Move();
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

    public void print() {
        System.out.println(name.toString() + " : " + move.toString());
    }

    public int getMoveCount() {
        return move.getMoveCount();
    }

    public String getCarName() {
        return name.toString();
    }

    private void validateNameLength(String carName) {
        if (isNameTooLong(carName)) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다");
        }
    }

    private void validateCarNameEmpty(String carName) {
        if (isNullOrBlank(carName)) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다");
        }
    }

    private boolean isNameTooLong(String carName) {
        return carName.length() > 5;
    }

    private boolean isNullOrBlank(String carName) {
        return carName == null || carName.trim().isEmpty();
    }
}
