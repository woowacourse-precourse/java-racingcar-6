package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCar;
import racingcar.utils.InputValidator;
import racingcar.utils.RandomNumberGenerator;
import racingcar.utils.StringConvertor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    public void start() {
        List<String> carNames = getCarNames();
        int tryNumber = getTryNumber();
        RacingCar car = getRacingCar(carNames);

        OutputView.printGameResultStatement();
        for (int i = 0; i < tryNumber; i++) {
            gamePlay(car.getRacingCar());
        }
        gameWinner(car.getWinnerList());
    }

    public List<String> getCarNames() {
        String carInput = InputView.inputCarNames();
        carInput = StringConvertor.removeSpace(carInput);
        List<String> carNames = StringConvertor.convertStringToList(carInput);
        InputValidator.checkCarNames(carNames, carInput);

        return carNames;
    }

    public int getTryNumber() {
        String tryNumber = InputView.inputTryNumber();
        tryNumber = StringConvertor.removeSpace(tryNumber);
        InputValidator.checkTryNumberIsInteger(tryNumber);
        System.out.println();

        return StringConvertor.convertStringToInt(tryNumber);
    }

    public RacingCar getRacingCar(List<String> carNames) {
        return new RacingCar(carNames);
    }

    public void gamePlay(List<Car> racingCar) {
        for (Car car : racingCar) {
            car.go();
            OutputView.printResult(car);
        }
        System.out.println();
    }

    public void gameWinner(List<String> racingWinners) {
        OutputView.printWinners(racingWinners);
    }

}
