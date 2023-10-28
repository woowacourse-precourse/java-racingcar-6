package racingcar.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.CarDto;
import racingcar.model.Cars;
import racingcar.view.InputView;


public class CarController {

    private Cars cars;
    private final InputView inputView;

    public CarController(Cars cars, InputView inputView) {
        this.cars = cars;
        this.inputView = inputView;
    }

    public void play()  {
        cars = new Cars(inputView.getPlayerNamesInput());
        getTryCountFromInput();
    }
    public List<CarDto> getCarDtos() {
        return cars.getCars().stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }
    private void getTryCountFromInput() {
        inputView.inputTryCount();
    }

}
