package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.domain.game.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private RacingGame racingGame;

    public GameController(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void run() {
        List<Car> cars = createCars();
        int tryCount = InputView.askTryCount();
        racingGame.progress(cars, tryCount);
        OutputView.printCurrentSituation(cars);
        OutputView.printWinner(cars);
    }

    private List<Car> createCars() {
        String str = InputView.askCarNames();
        validatePattern(str);
        List<String> carNames = stringToList(str);
        return carNames.stream()
                .map(name -> new Car(new Name(name)))
                .collect(Collectors.toList());
    }

    private void validatePattern(String str) {
        String regex = "(\\w{1,})(,\\w)*";
        if (!Pattern.matches(regex, str)) {
            throw new IllegalArgumentException("형식이 맞지 않습니다");
        }
    }

    private List<String> stringToList(String str) {
        return Arrays.stream(str.split(","))
                .collect(Collectors.toList());

    }
}
