package racingcar;

public class Car {

    private final String carName;
    private int position = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public CarStatusDto move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
        return new CarStatusDto(carName, position);
    }

    public String getName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

}
