package racingcar.controller;

import racingcar.dto.NamesRequestDto;
import racingcar.dto.CarsResponseDto;
import racingcar.dto.WinnerResponseDto;
import racingcar.service.CarService;

public class CarController {

    private final CarService carService = new CarService();

    public void createCars(NamesRequestDto cars) {
        carService.addCars(cars);
    }

    public CarsResponseDto raceCar() {
        return carService.raceCar();
    }

    public WinnerResponseDto getWinners() {
        return carService.getWinners();
    }
}
