package racingcar.dto;

import java.util.List;

public class CarsState {
    private final List<CarState> carsState;

    public CarsState(List<CarState> carsState) {
        this.carsState = carsState;
    }

    public List<CarState> getCarsState() {
        return carsState;
    }
}
