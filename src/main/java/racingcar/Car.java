package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private final String name;
    private final int displacement;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int displacement) {
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

    private boolean isAbleToProceed() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber > 3;
    }

    private Car proceed() {
        return new Car(name, displacement + 1);
    }

    @Override
    public int compareTo(Car competitor) {
        return this.displacement - competitor.displacement;
    }
}
