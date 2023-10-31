package racingcar.model.gameinfo;

public class CarInfo {
    private final String carName;
    private int currentPosition;

    public CarInfo(String carName) {
        this.carName = carName;
        this.currentPosition = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void proceed() {
        this.currentPosition = this.currentPosition + 1;
    }
}
