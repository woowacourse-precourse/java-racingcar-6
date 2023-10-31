package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.CarList.Car;
import racingcar.domain.CarList.CarDto;
import racingcar.domain.CarList.Cars;

public class RacingService {

    private final Cars cars = new Cars();
    private final List<CarDto> carDtoList = new ArrayList<>();

    public void setCars(List<String> userInput) {
        cars.setCarName(userInput);
    }

    public List<CarDto> startRacing() {
        carDtoList.clear();
        for (Car car : cars.carList) {
            car.checkMoveOrNot();
            CarDto carDto = car.createDto();
            carDtoList.add(carDto);
        }
        return carDtoList;
    }
}
