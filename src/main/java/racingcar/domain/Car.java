package racingcar.domain;


public class Car {

    private static final int MINIMUM_MOVE_VALUE = 4;

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int randomValue) {
        if (randomValue >= MINIMUM_MOVE_VALUE) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String display() {
        StringBuilder display = new StringBuilder(name + " : ");
        for (int i = 0; i< position; i++) {
            display.append("-");
        }
        return display.toString();
    }
}
