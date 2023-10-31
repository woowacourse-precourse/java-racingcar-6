package racingcar.domain;

public class Car {

    private static final int MAX_NAME_SIZE = 5;
    private String name;
    private String distance = "";

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String moveForward() {
        distance += "-";
        return distance;
    }

    public String moveStop() {
        return distance;
    }

    public int located() {
        return distance.length();
    }

    public String getName() {
        return name;
    }

    public void validateName(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 최소 1자 이상 입력해야 합니다.");
        }
    }

    public void clear() {
        distance = "";
    }
}
