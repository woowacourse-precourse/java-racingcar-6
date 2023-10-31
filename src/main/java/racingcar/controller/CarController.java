package racingcar.controller;

import racingcar.dto.namesRequestDto;
import racingcar.dto.CarsResponseDto;
import racingcar.dto.WinnerResponseDto;
import racingcar.service.CarService;

public class CarController {

    private CarService carService = new CarService();

    public void createCars(namesRequestDto cars) {
        carService.addCars(cars);
    }

    public CarsResponseDto raceCar() {
        return carService.raceCar();
    }

    public WinnerResponseDto getWinners() {
        return carService.getWinners();
    }
}
