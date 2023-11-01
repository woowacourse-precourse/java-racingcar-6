package racingcar;

public class CarObject {
    private final String CARNAME;
    private int carPosition;

    public CarObject(String name, int position) {
        CARNAME = name;
        carPosition = position;
    }

    public String getCarName() {
        return CARNAME;
    }

    public void setCarPosition() {
        carPosition += 1;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
