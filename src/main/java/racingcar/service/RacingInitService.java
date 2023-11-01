package racingcar.service;

import java.util.LinkedHashSet;
import java.util.List;
import racingcar.domain.Car;
import racingcar.dto.CarDto;
import racingcar.mapper.CarDtoMapper;
import racingcar.model.InputCarNameSplitter;
import racingcar.validator.ValidatorFactory;

public class RacingInitService {
    private final InputCarNameSplitter splitter;

    public RacingInitService(InputCarNameSplitter splitter) {
        this.splitter = splitter;
    }

    public List<String> carValidate(String carNamesInput) {
        String validatedCarNameInput = ValidatorFactory.forInputCarName().validate(carNamesInput);
        List<String> carNames = splitter.splitInputCarNames(validatedCarNameInput);

        return ValidatorFactory.forIndividualCarName().validate(carNames);
    }
    public String attemptCountValidate(String countInput) {
        return ValidatorFactory.forAttemptCount().validate(countInput);
    }

    public LinkedHashSet<Car> createCars(List<String> validatedCarNames) {
        RaceCarEnroller enroller = new RaceCarEnroller();
        return enroller.enrollCars(validatedCarNames);
    }

    public LinkedHashSet<CarDto> createCarDtos(LinkedHashSet<Car> cars) {
        LinkedHashSet<CarDto> carDtos = new LinkedHashSet<>();
        for (Car car : cars) {
            carDtos.add(CarDtoMapper.from(car));
        }
        return carDtos;
    }
}
