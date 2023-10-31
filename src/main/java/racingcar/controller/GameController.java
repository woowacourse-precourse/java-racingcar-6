package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.domain.car.Cars;
import racingcar.domain.game.RacingGame;
import racingcar.domain.generator.RacingRandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    public void run() {
        RacingGame racingGame = createRacingGame();
        while (racingGame.isRun()) {
            racingGame.progress();
            OutputView.printCurrentSituation(racingGame.getCars());
        }
        OutputView.printWinner(racingGame.getWinner());
    }

    private RacingGame createRacingGame() {
        Cars cars = createCars();
        int maxProgressCount = InputView.askMaxProgressCount();
        return RacingGame.createRacingGame(cars,
                maxProgressCount);
    }

    private Cars createCars() {
        String str = InputView.askCarNames();
        validatePattern(str);
        List<String> carNames = stringToList(str);
        return Cars.createCars(carNames,new RacingRandomNumberGenerator());
    }

    private void validatePattern(String str) {
        String regex = "\\w+(,\\w+)*";
        if (!Pattern.matches(regex, str)) {
            throw new IllegalArgumentException("형식이 맞지 않습니다");
        }
    }

    private List<String> stringToList(String str) {
        return Arrays.stream(str.split(","))
                .collect(Collectors.toList());
    }
}
