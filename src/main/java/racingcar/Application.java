package racingcar;

import racingcar.config.AppConfig;
import racingcar.domain.CarPark;
import racingcar.game.Game;
import racingcar.ioadapter.IoAdapter;
import racingcar.message.GameMessage;
import racingcar.service.InputConvertService;
import racingcar.vo.RoundCount;

public class Application {

    private static final AppConfig appConfig = new AppConfig();


    public static void main(String[] args) {
        IoAdapter ioAdapter = appConfig.ioAdapter();
        InputConvertService inputConvertService = appConfig.inputConvertService();
        Game racingGame = appConfig.game();
        ioAdapter.printMessage(GameMessage.START_MESSAGE.getMessage());
        String inputStream = ioAdapter.inputStream();
        CarPark carPark = inputConvertService.inputConvertCarPark(inputStream);
        ioAdapter.printMessage(GameMessage.ASK_ATTEMPT_MESSAGE.getMessage());
        String inputAttempt = ioAdapter.inputStream();
        RoundCount roundCount = inputConvertService.inputConvertRoundCount(inputAttempt);
        int i = 0;
        ioAdapter.printMessage(GameMessage.RESULT_MESSAGE.getMessage());
        while (!roundCount.isRoundFinishState(i)) {
            racingGame.playGame(carPark);
            ioAdapter.outputResult(carPark.getCarScores());
            ioAdapter.printNewLine();
            i++;
        }
        ioAdapter.printMessage(carPark.getWinnerList());
    }
}
