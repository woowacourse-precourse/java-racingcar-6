package racingcar.domain.CarList;

public class CarDto {

    public CarDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    private String carName;
    private int position;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
