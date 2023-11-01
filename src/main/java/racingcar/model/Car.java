package racingcar.model;

public class Car {

    private String carName;
    private int position;

    public Car(String name) {
        this.carName = name;
        this.position = 0;
    }

    public String getCurrentResultPosition() {

        StringBuilder currentResult = new StringBuilder();

        for (int i = 0; i < position; i++) {
            currentResult.append("-");
        }

        return carName + " : " + currentResult.toString();
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

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

}
