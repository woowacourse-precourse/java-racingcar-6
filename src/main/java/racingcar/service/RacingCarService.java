package racingcar.service;

import racingcar.converter.DtoConverter;
import racingcar.domain.*;
import racingcar.domain.dto.RunningCarDto;
import racingcar.domain.dto.WinnerDto;
import racingcar.domain.validator.InputValidator;
import racingcar.util.StringManipulator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarService {
    private final Cars cars;
    private int tryNumber;

    public RacingCarService(Cars cars) {
        this.cars = cars;
    }

    public void inputValidate(String input, InputValidator inputValidator) {
        inputValidator.validate(input);
    }

    public void insertCarNames(String carNames) {
        List<String> names = StringManipulator.split(carNames);
        cars.insertCarsNames(names);
    }

    public void insertTryNumber(String inputNumber) {
        tryNumber = Integer.parseInt(inputNumber);
    }

    public List<RunningCarDto> rushCars() {
        List<Car> carList = cars.rushCars();
        return carList.stream()
                .map(DtoConverter::toRunningCarDto)
                .collect(Collectors.toList());
    }

    public boolean isRaceOver() {
        return tryNumber == 0;
    }

    public List<WinnerDto> getWinner() {
        List<Car> winners = cars.findWinners();
        return winners.stream()
                .map(DtoConverter::toWinnerDto)
                .collect(Collectors.toList());
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
