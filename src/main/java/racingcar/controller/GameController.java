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

        /* 자동차 이름들, 시도 횟수 입력 */
        List<Car> cars = inputCarNames();
        int attemptNumber = inputAttempCnt();

        gameService.createGame(cars, attemptNumber);
        OutputView.printResultMessage();

        /* 게임진행 */
        while (true) {
            gameService.playSingleRoundGame();
            gameService.printCurrentGameResult();

            if (gameService.isFinalAttepmt()) {
                break;
            }
        }

        printWinner(gameService.getGameWinner());

    }

    public List<Car> inputCarNames(){
        InputView.inputCarNamesMessage();
        List<String> carNames = parser.parseCarName(Console.readLine());
        List<Car> cars = parser.parseStringToCar(carNames);
        return  cars;
    }

    public int inputAttempCnt(){
        InputView.inputNumberOfAttemptCntMessage();
        return parser.parseAttempt(Console.readLine());
    }

    public void printWinner(List<String> winners){
        if (winners.size() == 1) {
            OutputView.printSoloWin(winners.get(0));
        }
        if (winners.size() > 1) {
            OutputView.printWinners(winners);
        }
    }


}
