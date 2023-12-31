package racingcar.controller;

import java.util.stream.Stream;
import racingcar.dto.CarsRequestDto;
import racingcar.dto.CountRequestDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Count;
import racingcar.service.RacingCarService;
import racingcar.view.input.CarsInputView;
import racingcar.view.input.CountInputView;
import racingcar.view.output.OutputView;

public class RacingCarController {
    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void run() {
        Cars cars = toCars(CarsInputView.readCars());
        Count count = toCount(CountInputView.readCount());
        racingCarService.play(cars, count);
        OutputView.printTrack(racingCarService.getTrack());
        OutputView.printWinner(racingCarService.getWinners());
    }

    private Cars toCars(CarsRequestDto carsRequestDTO) {
        String names = carsRequestDTO.getNames();
        return new Cars(
                Stream.of(names.split(","))
                        .map(name -> new Car(name.trim()))
                        .toList()
        );
    }

    private Count toCount(CountRequestDto countRequestDto) {
        return new Count(countRequestDto.getCount());
    }
}
