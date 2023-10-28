package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.io.InputView;
import racingcar.io.OutputView;

public class RacingController {

    private List<RacingCar> racingCars;

    public void run() {
        OutputView.printRequestCarNames();
        makeCars(InputView.carNamesInput());
        int tryCount = inputTryCount();
        OutputView.printGameResultMessage();

        for (int i = 0; i < tryCount; i++) {
            moveCars();
            System.out.println();
        }

        OutputView.printResultMessage(findWinner(findMaxLocation()));
    }

    public void makeCars(String carNames) {

        racingCars = new ArrayList<>();

        String[] carNamesInputSplit = carNames.split(",");
        for (String carName : carNamesInputSplit) {
            racingCars.add(new RacingCar(carName));
        }

    }

    public int inputTryCount() {
        OutputView.printRequestTryCount();
        String tryCountInput = InputView.tryCountInput();
        return Converter.stringToInt(tryCountInput);
    }

    public void moveCars() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move();
            OutputView.printCarLocation(racingCar);
        }
    }

    public int findMaxLocation() {

        int max = Integer.MIN_VALUE;

        for (RacingCar racingCar : racingCars) {
            max = Math.max(max, racingCar.getLocation());
        }

        return max;
    }

    public List<RacingCar> findWinner(int maxLocation) {

        List<RacingCar> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getLocation() == maxLocation) {
                winners.add(racingCar);
            }
        }

        return winners;
    }

}
