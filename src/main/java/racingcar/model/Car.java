package racingcar.model;

public class Car {

    private String carName;
    private int position;

    public Car(String name) {
        this.carName = name;
        this.position = 0;
    }

    public int forwardPosition(int randomNumber) {
        if (randomNumber >= 4) {
            addPosition();
        }
        return position;
    }

    public void addPosition() {
        position += 1;
    }

}
