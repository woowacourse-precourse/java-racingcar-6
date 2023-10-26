package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        RaceException.validateCarName(name);
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
