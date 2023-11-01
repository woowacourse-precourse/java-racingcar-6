package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {

    private List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> findWinners(){
        int maxMoveCnt = findMaxMoveCnt();
        return carList.stream()
                .filter(car -> car.getMoveCnt() == maxMoveCnt)
                .collect(Collectors.toList());
    }


    private int findMaxMoveCnt(){
        return carList.stream()
                .mapToInt(Car::getMoveCnt)
                .max()
                .orElse(0);
    }

}
