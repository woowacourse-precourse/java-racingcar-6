package racingcar.Domain;

public class Car {
    private String carName;
    private int movedCount;
    private String movedStatus;

    public Car(String carName) {
        this.carName = carName;
        this.movedCount = 0;
        this.movedStatus = "";
    }

    public void addMovedCount() {
        this.movedCount++;
    }

    public void updateMovedStatus() {
        this.movedStatus += "-";
    }

    public String getCarName() {
        return carName;
    }

    public int getMovedCount() {
        return movedCount;
    }

    public String getMovedStatus() {
        return movedStatus;
    }
}
