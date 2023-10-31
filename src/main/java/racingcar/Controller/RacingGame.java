package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.Validator;
import racingcar.Model.Car;
import racingcar.Model.Cars;
import racingcar.Model.GameStatus;

public class RacingGame {
    private Validator validator = new Validator();
    private GameStatus gameStatus;

    public void run() {
        gameSetting();
        play();
    }

    private void gameSetting() {
        String carname = carNamesInput();
        Cars cars = createCars(carname);
        int playCount = parsePlayCount(playCountInput());
        this.gameStatus = new GameStatus(cars, playCount);
    }

    private void play() {
        OutputView.printStart();
        while (!gameStatus.isEnd()) {
            gameStatus.carsMoveForward();
            OutputView.printCurrentStatus(gameStatus.getCarNames(), gameStatus.getCarpositions());
            gameStatus.nextStatus();
        }
        OutputView.printWinner(gameStatus.getMaxCarNames());
    }

    private Cars createCars(String input) {
        List<Car> carList = createCarList(splitCarNames(input));
        Cars cars = new Cars(carList);
        return cars;
    }

    private List<Car> createCarList(List<Object> carNames) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.size(); i++) {
            carList.add(new Car(carNames.get(i).toString()));
        }
        return carList;
    }

    private List<Object> splitCarNames(String input) {
        validator.validateEmptyCarNames(input);
        List<Object> carNames = Arrays.asList(input.split(","));
        return carNames;
    }

    private String carNamesInput() {
        InputView.requestCarNames();
        String input = Console.readLine();
        return input;
    }

    private String playCountInput() {
        InputView.requestPlayCount();
        String input = Console.readLine();
        return input;
    }

    private int parsePlayCount(String input) {
        int playCount = validator.validatePlayCount(input);
        return playCount;
    }
}
