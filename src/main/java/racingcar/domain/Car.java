package racingcar.domain;

public class Car {
    String name;
    String position;

    public Car(String carName) {
        name = carName;
        position = "";
    }

    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String movingCar) {
        position += movingCar;
    }
    public int positionNumber() {
        return position.length();
    }

    public boolean isWinner(int maxPosition) {
        return positionNumber() == maxPosition;
    }
}
