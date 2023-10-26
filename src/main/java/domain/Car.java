package domain;

public class Car {
    private final String carName;
    public final Count count;

    public Car(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException();
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.carName = carName;
        this.count = new Count();
    }

    public String getCarName() {
        return this.carName;
    }

    public void moveOrStop(int randomNumber) {
        if (randomNumber >= 4) {
            count.plusForward();
        }
    }
}
