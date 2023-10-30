package racingcar.model;


public class Car {

    private static final int FORWARD_NUMBER = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int location;

    public Car(String carName) {
        nameLengthValidation(carName);
        this.name = carName;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void forward(int randomNumber) {
        if (randomNumber >= FORWARD_NUMBER) {
            this.location++;
        }
    }

    public boolean isMaxLocation(int maxLocation) {
        return this.location == maxLocation;
    }

    private void nameLengthValidation(String carName) {
        if (!(carName.length() <= MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }
}
