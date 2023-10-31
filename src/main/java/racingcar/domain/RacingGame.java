package racingcar.domain;

import racingcar.veiw.InputView;
import racingcar.veiw.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public void startGame() {
        String inputNames = InputView.getCarNames();
        Validator.name(inputNames);
        String inputRound = InputView.getRoundNumber();
        Validator.round(inputRound);

        OutputView.startRepeat();
        int repeatNumber = Integer.parseInt(inputRound);
        List<Car> carList = generateCarList(inputNames);
        List<Car> resultList = repeatRound(repeatNumber, carList);
        OutputView.gameResult(determineWinners(resultList));
    }

    private static List<Car> generateCarList(String inputNames) {
        String[] inputArray = inputNames.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : inputArray) {
            carList.add(generateCar(name));
        }
        return carList;
    }
    private static Car generateCar(String name) {
        return new Car(name);
    }
    private static List<Car> repeatRound(int repeatNumber, List<Car> carList) {
        for (int i = 0; i < repeatNumber; i++) {
            for (Car car : carList) {
                car.moveForward();
                OutputView.positionResult(car);
            }
            System.out.println();
        }
        return carList;
    }
    private static List<String> determineWinners(List<Car> resultList) {
        List<String> winnerList = new ArrayList<>();
        for (Car car : resultList) {
            int maxPosition = getMaxPosition(resultList);
            if (maxPosition == car.position) {
                winnerList.add(car.name);
            }
        }
        return winnerList;
    }
    private static int getMaxPosition(List<Car> carList) {
        int maxPosition = 0;
        for (Car car : carList) {
            if (maxPosition < car.position) {
                maxPosition = car.position;
            }
        }
        return maxPosition;
    }
}
