package racingcar.domain.entity;

public class CarEntity {
    private final String carName;
    private int position;

    public CarEntity(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void movePosition() {
        this.position++;
    }
}
