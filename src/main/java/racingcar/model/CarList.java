package racingcar.model;

import java.util.List;

public class CarList {

    private List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int findMaxMoveCnt(){
        return carList.stream()
                .mapToInt(Car::getMoveCnt)
                .max()
                .orElse(0);
    }
}
