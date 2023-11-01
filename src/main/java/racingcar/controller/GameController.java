package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.sevice.GameService;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final GameService gameService = new GameService(new Game());
    private final Parser parser = new Parser();


    public GameController() {
    }


    public void play() {

        // 자동차 이름들 입력
        InputView.inputCarNamesMessage();
        List<String> carNames = parser.parseCarName(Console.readLine());
        List<Car> cars = parser.parseStringToCar(carNames);

        //시도횟수 입력
        InputView.inputNumberOfAttemptCntMessage();
        int attemptNumber = parser.parseAttempt(Console.readLine());
        gameService.createGame(cars, attemptNumber);
        OutputView.printResultMessage();

        // 게임진행
        while (true) {
            gameService.playSingleRoundGame();
            gameService.printCurrentGameResult();

            if (gameService.isFinalAttepmt()) {
                break;
            }
        }

        List<String> winners = gameService.getGameWinner();
        if (winners.size() == 1) {
            OutputView.printSoloWin(winners.get(0));
        }
        if (winners.size() > 1) {
            OutputView.printWinners(winners);
        }

    }


}
