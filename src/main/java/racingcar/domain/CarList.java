package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {

    private final List<Car> carList;

    
    public CarList() {
        this.carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void addCarList(Car car) {
        this.carList.add(car);
    }

    public int getRacingCarWinnerLocation() {
        return carList.stream()
                .mapToInt(Car::getLocation)
                .max()
                .getAsInt();
    }

    public List<String> getRacingCarWinnerName(int winnerLocation) {
        return carList.stream()
                .filter(car -> car.getLocation() == winnerLocation)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}

