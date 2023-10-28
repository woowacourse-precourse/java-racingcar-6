package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.util.RacingGameUtil;
import racingcar.view.InputManager;
import racingcar.view.OutputManager;

public class GameController {

    public void run() {
        String carNames = getCarNameFromUser();
        List<Car> cars = makeCar(carNames);
        Integer gameCycleNumber = getGameCycleNumberFromUser();
        playRacingGame(gameCycleNumber, cars);
    }

    private void playRacingGame(Integer gameCycle, List<Car> cars) {
        OutputManager.printGameStart();
        for (int i = 0; i < gameCycle; i++) {
            for (Car car : cars) {
                int randNumber = Randoms.pickNumberInRange(0, 9);
                car.go(randNumber);
            }
            printEachCycleResult(cars);
        }
        printResult(cars);
    }

    private void printResult(List<Car> cars) {
        List<String> winnerNames = findWinnerName(cars);
        OutputManager.printWinner(winnerNames.stream().collect(Collectors.joining(", ")));
    }

    private static List<String> findWinnerName(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerNames.add(car.getName());
                continue;
            }
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winnerNames = new ArrayList<>();
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    private void printEachCycleResult(List<Car> cars) {
        for (Car car : cars) {
            OutputManager.printEachCycleResult(car.getName(), car.getPosition());
        }
        System.out.println();
    }


    private Integer getGameCycleNumberFromUser() {
        InputManager.requestGameCycleNumber();
        Integer gameCycleNumber = Integer.valueOf(Console.readLine());
        validationGameCycle(gameCycleNumber);
        System.out.println();
        return gameCycleNumber;
    }

    private void validationGameCycle(Integer gameCycleNumber) {
        if (!Character.isDigit(gameCycleNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> makeCar(String carNames) {
        List<Car> cars = new ArrayList<>();
        List<String> carNameList = RacingGameUtil.splitCarNames(carNames);
        for (String carName : carNameList) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    private String getCarNameFromUser() {
        InputManager.requestCarName();
        return Console.readLine();
    }
}
