package racingcar;

import racingcar.domain.Car;
import racingcar.validator.Validator;
import racingcar.veiw.InputView;
import racingcar.veiw.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public void startGame() {
        String inputNames = InputView.requestCarNames();
        Validator.validateCarNames(inputNames);

        String inputRound = InputView.requestRoundNumber();
        Validator.validateRoundValue(inputRound);

        OutputView.printExecutionMessage();

        List<Car> carList = generateCarList(inputNames);
        int repeatNumber = Integer.parseInt(inputRound);
        List<Car> resultList = repeatRounds(repeatNumber, carList);

        List<String> winners = determineWinners(resultList);
        OutputView.printWinners(winners);
    }

    private static List<Car> generateCarList(String inputNames) {
        String[] inputArray = inputNames.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : inputArray) {
            carList.add(new Car(name));
        }
        return carList;
    }
    private static List<Car> repeatRounds(int repeatNumber, List<Car> carList) {
        for (int i = 0; i < repeatNumber; i++) {
            for (Car car : carList) {
                car.moveForward();
                OutputView.printPosition(car);
            }
            System.out.println();
        }
        return carList;
    }
    private static List<String> determineWinners(List<Car> resultList) {
        int maxPosition = getMaxPosition(resultList);
        List<String> winnerList = new ArrayList<>();
        for (Car car : resultList) {
            if (maxPosition == car.position) {
                winnerList.add(car.name);
            }
        }
        return winnerList;
    }
    private static int getMaxPosition(List<Car> carList) {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.position);
        }
        return maxPosition;
    }
}
