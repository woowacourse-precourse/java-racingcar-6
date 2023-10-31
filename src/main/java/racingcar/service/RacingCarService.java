package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarDto;
import racingcar.model.RacingCars;
import racingcar.util.RandomNuberGenerator;

public class RacingCarService {
    public static final String COMMA_SEPARATOR = ",";
    private final RacingCars racingCars;

    public RacingCarService(String carNames) {
        this.racingCars = new RacingCars(Arrays.asList(carNames.split(COMMA_SEPARATOR)));
    }

    public void moveRacingCars() {
        List<Integer> randomNumbers = RandomNuberGenerator.createRandomNumbers(racingCars.getSize());
        racingCars.moveRacingCars(randomNumbers);
    }

    public List<CarDto> getRacingCarDto() {
        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : racingCars.getRacingCars()) {
            carDtoList.add(new CarDto(car.getName(), car.getDistance()));
        }
        return carDtoList;
    }

}
