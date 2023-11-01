package racingcar.Model;

public class Car {
    private String name;
    private Integer forwardValue;

    public Car(String name) {
        // 이름 5글자 초과일 경우 에러
        if (name.length() > 5) throw new IllegalArgumentException("Error : 이름 5글자 초과일 경우");

        this.name = name;
        forwardValue = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getForwardValue() {
        return forwardValue;
    }

    public void forward() {
        this.forwardValue += 1;
    }

    @Override
    public String toString() {
        return String.format("자동차 (이름 = %s, 위치 = %s)", name, forwardValue);
    }
}
