package racingcar.Model;

public class Car {
    private String carName;
    private int moveCount;
    private String distance = "";

    public Car(String carName, int moveCount) {
        this.carName = carName;
        this.moveCount = moveCount;
    }

    public String getName() {
        return this.carName;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void accel() {
        this.moveCount += 1;
        this.distance += "-";
    }

    public String getCurrentState() {
        return this.carName + " : " + this.distance;
    }
}
