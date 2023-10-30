package racingcar.service;

import java.util.List;
import racingcar.domain.CarList.CarDto;
import racingcar.domain.CarList.Cars;

public class RacingService {

    private final Cars cars = new Cars();

    public void setCars(List<String> userInput) {
        cars.setCarName(userInput);
    }

    public List<CarDto> startRacing() {
        return cars.setCarMoveStatus();
    }
}
