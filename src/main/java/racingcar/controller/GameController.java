package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {

    private static final int RACE_COUNT_MINIMUM = 1;

    private InputView inputView;
    private OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startRace() {
        String carsName = inputView.readCarsName();
        List<Car> carList = createCarList(carsName);

        int raceCount = inputView.readCarMoveCount();
        validateRaceCount(raceCount);
        outputView.printRaceStart();

        race(carList, raceCount);
        announceWinner(carList);
    }

    private List<Car> createCarList(String carsName) {
        List<String> carNameList = convertStringToList(carsName);
        List<Car> carList = new ArrayList<>();

        for (int carNameIndex = 0; carNameIndex < carNameList.size(); carNameIndex++) {
            carList.add(new Car(carNameList.get(carNameIndex)));
        }

        return carList;
    }

    private List<String> convertStringToList(String carsName) {
        List<String> carNameList = Arrays.asList(carsName.split(","));
        validateDuplicateName(carNameList);
        return carNameList;
    }

    private void validateDuplicateName(List<String> carNameList) {
        int uniqueCarNameCount = (int) carNameList.stream()
                .distinct()
                .count();

        if (uniqueCarNameCount != carNameList.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRaceCount(int raceCount) {
        if (raceCount < RACE_COUNT_MINIMUM) {
            throw new IllegalArgumentException();
        }
    }

    private void race(List<Car> carList, int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            for (Car car : carList) {
                car.move(NumberGenerator.createRandomNumber());
            }
            outputView.printCarsProgress(carList);
        }
    }

    private void announceWinner(List<Car> carList) {
        List<String> winnerList = Referee.findMostProgressCar(carList);
        outputView.printWinner(winnerList);
    }
}
