package racingcar.service;

import racingcar.domain.Car;
import racingcar.util.GlobalExceptionHandler;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    private final static RacingCarView racingCarView = new RacingCarView();
    private final static GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    private static List<String> getCarsNameList(String cars) {
        List<String> carArray = new ArrayList<>();
        if (globalExceptionHandler.isValidCarArray(cars)) {
            carArray = List.of(cars.split(","));
        }
        return carArray;
    }

    public List<Car> getRacingCarsList(String cars) {
        List<String> racingCars = getCarsNameList(cars);
        final List<Car> carList = new ArrayList<>();

        for (int i=0; i<racingCars.size(); i++){
            if (globalExceptionHandler.isValidCarName(racingCars.get(i))) {
                final Car car = new Car(racingCars.get(i));
                carList.add(car);
            }
        }
        return carList;
    }

}
