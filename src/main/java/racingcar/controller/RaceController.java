package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.PlayCount;
import racingcar.domain.Winners;
import racingcar.dto.CarDto;
import racingcar.view.InputViewable;
import racingcar.view.OutputViewable;

import java.util.List;
import java.util.stream.Collectors;

public class RaceController {

    private PlayCount playCount;
    private Cars cars;
    private final InputViewable inputView;
    private final OutputViewable outputView;

    public RaceController(InputViewable inputView, OutputViewable outputView) {
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
        while (playCount.canPlay(currentCount++)) {
            cars.play();
            printResult();
        }
        printFinalWinners();
    }

    private void printResult() {
        List<CarDto> carDtos = convertCarToDto();
        outputView.printResult(carDtos);
    }

    private List<CarDto> convertCarToDto() {
        return cars.getCars().stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    private void printFinalWinners() {
        List<String> winnersNames = getWinnersNames();
        outputView.printFinalWinners(winnersNames);
    }

    private List<String> getWinnersNames() {
        Winners winners = new Winners(cars.getCars());
        return winners.getWinners().stream()
                .map(Car::getName).toList();
    }
}
