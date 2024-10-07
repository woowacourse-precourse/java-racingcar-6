package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.GameData;
import racingcar.message.ViewMessage;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class MainController {

    public void run() {
        GameData gameData = initGame();
        proceedGame(gameData);
        endGame(gameData);
    }

    //게임 초기화(시작)
    private GameData initGame() {
        List<Car> carList =Converter.splitByDelimiter(InputView.inputString(ViewMessage.INPUT_CAR_NAMES), ",")
                            .stream()
                            .map(Car::new)
                            .toList();


        return new GameData(
                new Cars(carList),
                InputView.inputInteger((ViewMessage.INPUT_TRIAL_COUNT))
        );
    }


    //게임 진행
    private void proceedGame(GameData gameData) {
    int moveCount = 0;
        OutputView.printMessage(ViewMessage.GAME_RESULT);
        while (moveCount++ < gameData.trialCount()) {
            gameData.cars()
                    .moveRandomly();
            OutputView.printMovingResult(gameData.cars());
            System.out.println();
        }
    }

    //게임 종료
    private void endGame(GameData gameData) {
        List<Car> winner = gameData.cars().getWinnerList();
        OutputView.printWinner(winner);
    }

}
