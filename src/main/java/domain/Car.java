package domain;

public class Car {
    private final String carName;

    public Car(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException();
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.carName = carName;
    }

    public String getCarName() {
        return this.carName;
    }
}
