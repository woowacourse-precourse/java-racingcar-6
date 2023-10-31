package racingcar.domain;

public class Car {
    private final String name;
    private int position;
    private final int INITIAL_POSITION = 0;
    private final int FOWARD_CONDITION_NUMBER = 4;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public void move(int condition) {
        if (condition >= FOWARD_CONDITION_NUMBER) {
            position++;
        }
    }
}
