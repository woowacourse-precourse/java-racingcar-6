package racingcar;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (isMovable()) {
            this.position++;
        }
    }

    public static boolean isMovable() {
        return RandomNumberGenerator.generateRandomNumber() >= 4;
    }
}
