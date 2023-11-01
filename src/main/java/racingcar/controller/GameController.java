package racingcar.controller;

import racingcar.generator.MoveNumberGenerator;
import racingcar.model.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static racingcar.model.RacingCars.convertToCarList;

public class GameController {
    RacingResult racingResult;
    List<Name> carNames;

    public GameController() {
        racingResult = new RacingResult();
        carNames = new ArrayList<>();
    }

    public void startGame() {
        OutputView.printInputRacingCar();
        RacingCars racingCars = new RacingCars(convertToCarList(InputView.inputCarNames()));
        prepareRacing(racingCars);

        OutputView.printInputTryNumber();
        TryNumber tryNumber = new TryNumber(InputView.inputTryNumber());
        OutputView.printRacingResult();
        startRacing(tryNumber, racingCars);
        List<Name> finalWinner = determineFinalWinner();
        OutputView.printFinalWinner(finalWinner);
    }

    private List<Name> determineFinalWinner() {
        List<Name> finalWinners = new ArrayList<>();
        Distance maxDistance = getMaxDistance();

        Map<Name, Distance> result = racingResult.getRacingResult();

        for (Name name : carNames) {
            if (result.get(name).equals(maxDistance)) {
                finalWinners.add(name);
            }
        }
        return finalWinners;
    }

    private Distance getMaxDistance() {
        Distance distance = new Distance();
        int max = 0;

        Map<Name, Distance> result = racingResult.getRacingResult();

        for (Name name : carNames) {
            max = Math.max(max, result.get(name).getDistance());
        }
        distance.updateDistance(max);
        return distance;
    }

    private void prepareRacing(RacingCars racingCars) {
        List<Car> cars = racingCars.getRacingCars();
        prepareResultMap(cars);
        prepareCarNames(cars);
    }

    private void prepareResultMap(List<Car> cars) {
        Map<Name, Distance> result = racingResult.getRacingResult();
        for (Car car : cars) {
            result.put(car.getCarName(), new Distance());
        }
        racingResult.updateRacingResult(result);
    }

    private void prepareCarNames(List<Car> cars) {
        for (Car car : cars) {
            carNames.add(car.getCarName());
        }
    }

    private void startRacing(TryNumber number, RacingCars racingCars) {
        for (int racingCount = 0; racingCount < number.getNumber(); racingCount++) {
            playOneRound(racingCars);
            OutputView.printOneRoundResult(racingResult, carNames);
        }
    }

    private void playOneRound(RacingCars racingCars) {
        List<Car> carList = racingCars.getRacingCars();
        int carIdx = 0;
        for (Car car : carList) {
            car.move(MoveNumberGenerator.generateNumber());
            carList.set(carIdx, car);
            carIdx++;
        }
        racingCars.updateRacingCars(carList);
        updateRoundResult(racingCars);
    }

    private void updateRoundResult(RacingCars racingCars) {
        Map<Name, Distance> result = racingResult.getRacingResult();
        List<Car> cars = racingCars.getRacingCars();

        for (Car car : cars) {
            result.put(car.getCarName(), car.getCarDistance());
        }

        racingResult.updateRacingResult(result);
    }
}
