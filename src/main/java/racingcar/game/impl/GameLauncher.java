package racingcar.game.impl;

import racingcar.domain.CarPark;
import racingcar.game.Game;
import racingcar.game.Launcher;
import racingcar.ioadapter.IoAdapter;
import racingcar.message.GameMessage;
import racingcar.service.InputConvertService;
import racingcar.vo.RoundCount;

public class GameLauncher implements Launcher {

    private final IoAdapter ioAdapter;
    private final InputConvertService inputConvertService;
    private final Game racingGame;

    public GameLauncher(IoAdapter ioAdapter, InputConvertService inputConvertService, Game racingGame) {
        this.ioAdapter = ioAdapter;
        this.inputConvertService = inputConvertService;
        this.racingGame = racingGame;
    }

    public void StartGameLauncher() {
        CarPark carPark = makeCarPark();
        RoundCount roundCount = makeRoundCount();
        playRacing(carPark, roundCount);
        ioAdapter.printMessage(carPark.getWinnerList());
    }

    private void playRacing(CarPark carPark, RoundCount roundCount) {
        int round = 0;
        ioAdapter.printMessage(GameMessage.RESULT_MESSAGE.getMessage());
        while (!roundCount.isRoundFinishState(round)) {
            racingGame.playGame(carPark);
            ioAdapter.outputResult(carPark.getCarScores());
            ioAdapter.printNewLine();
            round++;
        }
    }

    private CarPark makeCarPark() {
        ioAdapter.printMessage(GameMessage.START_MESSAGE.getMessage());
        String inputStream = ioAdapter.inputStream();
        return inputConvertService.inputConvertCarPark(inputStream);
    }

    private RoundCount makeRoundCount() {
        ioAdapter.printMessage(GameMessage.ASK_ATTEMPT_MESSAGE.getMessage());
        String inputAttempt = ioAdapter.inputStream();
        return inputConvertService.inputConvertRoundCount(inputAttempt);
    }
}
