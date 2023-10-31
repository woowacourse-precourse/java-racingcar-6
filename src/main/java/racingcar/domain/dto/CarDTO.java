package racingcar.domain.dto;

public class CarDTO {
    private String carName;
    private int position;

    public CarDTO(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
