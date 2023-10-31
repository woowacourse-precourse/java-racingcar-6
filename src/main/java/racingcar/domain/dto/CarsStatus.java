package racingcar.domain.dto;

import java.util.List;

public class CarsStatus {
    private final List<CarStatus> carsStatus;

    public CarsStatus(List<CarStatus> carsStatus) {
        this.carsStatus = carsStatus;
    }

    public static CarsStatus from(List<CarStatus> carsStatus) {
        return new CarsStatus(carsStatus);
    }

    public List<CarStatus> getCarsStatus() {
        return carsStatus;
    }


}
