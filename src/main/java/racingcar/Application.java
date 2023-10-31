package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.InputProcessor;
import racingcar.domain.RacingGame;
import racingcar.domain.Referee;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputProcessor inputProcessor = new InputProcessor();
        List<String> carNames = inputProcessor.getCarNames();
        List<Car> cars = inputProcessor.getCars(carNames);
        Integer round = inputProcessor.getRound();

        Referee referee = new Referee();

        RacingGame racingGame = new RacingGame(cars, referee, round);
        racingGame.processRound();
    }
}
