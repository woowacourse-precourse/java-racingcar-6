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

        String[] inputArray = inputNames.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : inputArray) {
            carList.add(generateCar(name));
        }

        int repeatNumber = Integer.parseInt(inputRound);
        for (int i = 0; i < repeatNumber; i++) {
            for (Car car : carList) {
                car.moveForward();
                OutputView.positionResult(car);
            }
            System.out.println();
        }
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            int maxPosition = getMaxPosition(carList);
            if (maxPosition == car.position) {
                winnerList.add(car.name);
            }
        }
        OutputView.gameResult(winnerList);
    }
    private static Car generateCar(String name) {
        return new Car(name);
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
