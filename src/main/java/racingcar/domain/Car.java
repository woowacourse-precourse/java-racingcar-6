package racingcar.domain;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomNumber) {
        if (4 <= randomNumber && randomNumber <= 9) {
            distance++;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name);
        result.append(" : ");
        for (int i = 0; i < distance; i++) {
            result.append('-');
        }
        return result.toString();
    }
}
