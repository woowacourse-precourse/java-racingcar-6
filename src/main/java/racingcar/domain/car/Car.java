package racingcar.domain.car;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void updatePosition(int randomNumber) {
        if (randomNumber > 3) {
            this.position++;
        }
    }
}
