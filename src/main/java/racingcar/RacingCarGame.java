package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.io.InputView;
import racingcar.io.OutputView;
import racingcar.validator.UserInputValidator;

public class RacingCarGame {

    private List<RacingCar> racingCars = new ArrayList<>();

    public void run() {
        OutputView.printRequestCarNames();
        makeCars(Converter.stringToList(InputView.carNamesInput()));
        int tryCount = inputTryCount();
        OutputView.printGameResultMessage();

        for (int i = 0; i < tryCount; i++) {
            moveCars();
            System.out.println();
        }

        OutputView.printResultMessage(findWinner(findMaxLocation()));
    }

    public void makeCars(List<String> carNames) {
        UserInputValidator.validCarNameIsDuplicated(carNames);
        racingCars = carNames.stream().map(RacingCar::new).toList();
    }

    public int inputTryCount() {
        OutputView.printRequestTryCount();
        String tryCountInput = InputView.tryCountInput();
        return Converter.stringToInt(tryCountInput);
    }

    public void moveCars() {
        for (RacingCar racingCar : racingCars) {
            boolean canMove = racingCar.canMove(racingCar.getRandomNumber());
            racingCar.move(canMove);
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

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
