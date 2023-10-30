package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarList {

    private List<Car> carList;

    public List<Car> getCarList(){
        return carList;
    }

    public void addCarList(Car car){
        carList.add(car);
    }

    public int getRacingCarWinnerLocation() {
        return carList.stream()
                .mapToInt(Car::getLocation)
                .max()
                .getAsInt();
    }

    public List<String> getRacingCarWinnerName(int winnerLocation){
        return carList.stream()
                .filter(car -> car.getLocation() == winnerLocation)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}

