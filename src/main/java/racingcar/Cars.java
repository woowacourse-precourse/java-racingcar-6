package racingcar;

public class Cars {
    private final String carName;
    private int position = 0;

    public Cars(String carName) {
        this.carName = carName;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
