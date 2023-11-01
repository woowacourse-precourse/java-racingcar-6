package racingcar.model;

public class Car {
    private static final int MOVE = 1;
    private static final String MOVE_FORWARD = "-";
    private String name;
    private String carMovedResult;
    private int carState;

    public Car(String name) {
        this.name = name;
        carState = 0;
        carMovedResult = "";
    }

    public String getName() {
        return name;
    }

    public int getCarState() {
        return carState;
    }

    public void setCarState() {
        carState = carState + MOVE;
    }

    public String getCarMovedResult() {
        return carMovedResult;
    }

    public void setCarMovedResult() {
        carMovedResult = carMovedResult + MOVE_FORWARD;
    }
}
