package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputManager;

public class RacingGame {
    private final Integer gameCycle;
    private final List<Car> cars;

    public RacingGame(Integer gameCycleNumber, List<Car> cars) {
        this.gameCycle = gameCycleNumber;
        this.cars = cars;
    }

    public void playGame() {
        OutputManager.printGameStart();
        for (int i = 0; i < this.gameCycle; i++) {
            for (Car car : cars) {
                int randNumber = Randoms.pickNumberInRange(0, 9);
                car.go(randNumber);
            }
            printEachCycleResult(cars);
        }
        printResult(cars);
    }

    private void printEachCycleResult(List<Car> cars) {
        for (Car car : cars) {
            OutputManager.printEachCycleResult(car.getName(), car.getPosition());
        }
        System.out.println();
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
}
