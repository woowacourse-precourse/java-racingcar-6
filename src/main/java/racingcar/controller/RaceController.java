package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.PlayCount;
import racingcar.domain.Winner;
import racingcar.dto.CarDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RaceController {

    private PlayCount playCount;
    private Cars cars;
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        setRace();
    }

    public void setRace() {
        setCar();
        setPlayCount();
    }

    private void setCar() {
        String inputNames = inputView.askCarName();
        cars = new Cars(inputNames);
    }

    private void setPlayCount() {
        String inputPlayCount = inputView.askPlayCount();
        playCount = new PlayCount(inputPlayCount);
    }

    public void play() {
        outputView.printPlayMessage();
        int currentCount = 0;
        while(playCount.isPlay(currentCount++)) {
            cars.play();
            printResult();
        }
        printFinalWinner();
    }

    private void printResult() {
        List<CarDto> carDtos = cars.getCars().stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
        outputView.printResult(carDtos);
    }

    private void printFinalWinner() {
        Winner winner = new Winner(cars);
        List<String> winners = winner.findWinners();
        outputView.printFinalWinners(winners);
    }
}
