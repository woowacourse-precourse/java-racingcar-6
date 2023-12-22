package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.dto.CarsRequestDto;
import racingcar.dto.CountRequestDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Count;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final RacingCarService racingCarService;

    public Controller(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run() {
        Cars cars = cars(InputView.inputCars());
        Count count = count(InputView.inputCount());
        OutputView.printProgress(racingCarService.play(cars, count));
        OutputView.printResult(racingCarService.result());
    }


    private Cars cars(CarsRequestDto carsRequestDTO) {
        String[] names = carsRequestDTO.getNames();
        List<Car> cars = Arrays.stream(names)
                .map(name -> new Car(name.trim()))
                .toList();
        return new Cars(cars);
    }

    private Count count(CountRequestDto countRequestDto) {
        int count = countRequestDto.getCount();
        return new Count(count);
    }
}
