package racingcar.Model;

public class Car {
    private String name;
    private int distance = 0;

    public Car(String name) {
        name = name.trim();
        validateEmpty(name);
        validateNameLength(name);
        this.name = name;
    }

    void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름 길이가 5초과 입니다.");
        }
    }

    void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상이여야 합니다");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car && obj != null) {
            return name.equals(((Car) obj).getName());
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void incrementDistance() {
        this.distance++;
    }


}
