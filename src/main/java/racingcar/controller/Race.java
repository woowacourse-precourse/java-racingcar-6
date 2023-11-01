package racingcar.controller;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.util.CarDtoConverter;
import racingcar.model.Cars;
import racingcar.view.OutputView;

public class Race {
    private final Cars cars;
    private final OutputView outputView;

    public Race(Cars cars, OutputView outputView) {
        this.cars = cars;
        this.outputView = outputView;
    }

    void playGameAllRounds(int roundNumber) {
        System.out.println("실행 결과");
        for (int i=0; i<roundNumber; i++) {
            playGameSingleRound(cars);
        }
    }

    private void playGameSingleRound(Cars cars) {
        cars.carsMoving(cars);
        List<CarDto> carDtoList = CarDtoConverter.convertCarsToCarDtoList(cars);
        outputView.printSingleRound(carDtoList);
    }

}
