package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceNumberGenertor;
import racingcar.domain.WinnerCar;
import racingcar.domain.dto.CarStatusDto;
import racingcar.domain.dto.RaceResultDto;
import racingcar.service.CarService;
import racingcar.service.RaceService;
import racingcar.service.WinnerCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static racingcar.enumType.InputMessage.*;

import java.util.List;

public class CarRaceController {
    
    private final InputView inputView;

    private final OutputView outputView;

    private final CarService carService;

    private final RaceService raceService;

    private final WinnerCarService winnerCarService;

    private RaceNumberGenertor raceNumberGenertor;

    public CarRaceController() {
        inputView = new InputView();
        outputView = new OutputView();
        carService = new CarService();
        raceService = new RaceService(carService);
        winnerCarService = new WinnerCarService();
        raceNumberGenertor = new RaceNumberGenertor();
    }

    public void race() {
        String carNames = getCarNames();
        Cars cars = createCars(carNames);
        String tryCount = getTryCount();
        Race race = createRace(tryCount);

        printInitCarStatus(cars);
        printRaceResult(cars, race);
        printWinnerResult(cars);
    }

    private String getCarNames() {
        return inputView.getUserInput(() -> {
            OutputView.printMessage(GET_CAR_NAMES_MESSAGE.getValue());
            return inputView.randConsole();
        });
    }
    private Cars createCars(String carNames) {
        return carService.createCars(carNames, raceNumberGenertor);
    }

    private String getTryCount() {
        return inputView.getUserInput(() -> {
            OutputView.printMessage(GET_TRY_COUNT_MESSAGE.getValue());
            return inputView.randConsole();
        });
    }

    private Race createRace(String tryCount) {
        return raceService.createRace(tryCount);
    }

    private void printInitCarStatus(Cars cars) {
        List<CarStatusDto> initCarStatus = carService.getCarStatus(cars);
        outputView.printInitCarStatus(initCarStatus);
    }

    private void printRaceResult(final Cars cars, final Race race) {
        List<RaceResultDto> totalRaceResult = raceService.getRaceResults(cars, race);
        outputView.printRaceResult(totalRaceResult);
    }

    private void printWinnerResult(final Cars cars) {
        WinnerCar winnerCar = winnerCarService.createWinnerCar(cars);
        List<String> winnerCars = winnerCarService.getWinnerNames(winnerCar);
        outputView.printWinnerResult(winnerCars);
    }
}

