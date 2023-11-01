package racingcar.domain.dto;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class CarsDTO {
    private List<Car> carList;

    public CarsDTO() {

    }

    public void toDTO(Cars cars) {
        this.carList = cars.getCarList();
    }

    public List<Car> getCarList() {
        return carList;
    }

}
