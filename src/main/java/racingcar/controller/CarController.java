package racingcar.controller;

import racingcar.dto.namesRequestDto;
import racingcar.dto.ProgressResponseDto;
import racingcar.dto.WinnerResponseDto;
import racingcar.service.CarService;

public class CarController {

    private CarService carService = new CarService();

    public void createCars(namesRequestDto cars) {
        carService.addCars(cars);
    }

    public ProgressResponseDto raceCar() {
        return null;
    }

    public WinnerResponseDto getWinners() {
        return carService.getWinners();
    }
}
