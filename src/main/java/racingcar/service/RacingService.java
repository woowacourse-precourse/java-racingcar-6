package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.CarList.Car;
import racingcar.domain.CarList.CarDto;
import racingcar.domain.CarList.Cars;
import racingcar.util.generator.RandomNumberGenerator;

public class RacingService {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final Cars cars = new Cars();
    private final List<CarDto> carDtoList = new ArrayList<>();


    public void setCars(List<String> userInput) {
        cars.setCarName(userInput);
    }

    public List<CarDto> startRacing() {
        int randomNumber;
        carDtoList.clear();

        for (Car car : cars.carList) {
            randomNumber = randomNumberGenerator.generate();
            car.checkMoveOrNot(randomNumber);
            CarDto carDto = car.createDto();
            carDtoList.add(carDto);
        }
        return carDtoList;
    }
}
