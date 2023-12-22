package racingcar.model;

public class Car {
    private final String name;

    public Car(String name) {
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLength(String name) {
        if (name.length() > 4) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 4글자 이하로 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Car car) {
            return this.name.equals(car.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
