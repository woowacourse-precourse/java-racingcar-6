package racingcar.domain;

public class Car {

    private String name;
    private int forwardCount;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.forwardCount = 0;
    }

    private void validate(String name) {
        if (!(1 <= name.length() && name.length() <= 5)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public int moveForward(int value) {
        if (value >= 4) {
            forwardCount++;
        }
        return forwardCount;
    }

    public int getLargerForwardCount(int maxForwardCount) {
        return Math.max(forwardCount, maxForwardCount);
    }

    public boolean isSameAs(int forwardCount) {
        return this.forwardCount == forwardCount;
    }

    public String getName() {
        return name;
    }
}
