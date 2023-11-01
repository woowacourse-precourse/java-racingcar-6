package racingcar.dto;

import java.util.List;

public class CarResponse {
    private String carName;
    private int position;

    public CarResponse(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
