package racingcar.game.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private final String name;
    private final int displacement;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int displacement) {
        validateCarName(name);
        this.name = name;
        this.displacement = displacement;
    }

    public Car conductAction() {
        if (isAbleToProceed()) {
            return proceed();
        }
        return this;
    }

    public String showCurrentDisplacement() {
        return name + " : " + "-".repeat(Math.max(0, displacement));
    }

    public String displayName() {
        return name;
    }

    public boolean isTieWith(Car competitor) {
        return this.displacement == competitor.displacement;
    }

    @Override
    public int compareTo(Car competitor) {
        return this.displacement - competitor.displacement;
    }

    private boolean isAbleToProceed() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber > 3;
    }

    private Car proceed() {
        return new Car(name, displacement + 1);
    }

    private void validateCarName(String carName) {
        validateCarNameFormat(carName);
        validateCarNameFilled(carName);
        validateCarNameLength(carName);
    }

    private void validateCarNameFormat(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않은 자동차가 있습니다.");
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
    }

    private void validateCarNameFilled(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백이 포함된 자동차가 있습니다.");
        }
    }
}
