package racingcar;

import java.util.List;
import racingcar.domain.InputService;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameDisplay;
import racingcar.infra.DefaultRandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        InputService inputService = BeanFactory.inputService();
        List<String> carNames = inputService.getCarNames();
        int round = inputService.getRound();
        RacingGame racingGame = new RacingGame(carNames, round, new DefaultRandomNumberGenerator());

        System.out.println("\n실행 결과");
        racingGame.play();
        RacingGameDisplay.showWinners(racingGame.getWinners());
    }

}