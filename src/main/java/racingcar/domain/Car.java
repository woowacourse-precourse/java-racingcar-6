package racingcar.domain;

public class Car {

    private static final String POSITION_SYMBOL = "-";
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int position;

    public Car(String name) {

        this.name = name;
    }

    public static Car makeCar(String name) {

        return new Car(name);
    }

    public void tryMove(int randomNumber) {

        if (isMove(randomNumber)) {
            this.position++;
        }
    }

    private boolean isMove(int randomNumber) {

        return randomNumber >= MOVE_CONDITION;
    }

    public String getName() {

        return name;
    }

    public String getPosition() {

        return POSITION_SYMBOL.repeat(position);
    }
}
