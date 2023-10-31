package racingcar.Domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public static Car create(final String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void CarMove(int randomNumber) {
        if (randomNumber >= 4) {
            this.position++;
        }
    }

}
