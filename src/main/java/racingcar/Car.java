package racingcar;

public class Car {
    private static final String LOCATION = "-";
    private static final int MAX_NAME_LENGTH = 5;
    private String name;
    private String location = "";

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름이 " + MAX_NAME_LENGTH + "보다 깁니다.");
        }
    }

    public void move() {
        location += LOCATION;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + location;
    }
}
