package racingcar;

import java.util.List;
import racingcar.config.ApplicationContext;
import racingcar.controller.RacingGameController;
import racingcar.view.input.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationContext context = new ApplicationContext();

        InputView inputView = context.inputView();
        List<String> carNames = inputView.names();
        long numberOfAttempts = inputView.number();

        RacingGameController controller = context.racingGameController();

        try {
            controller.startRacingGame(carNames, numberOfAttempts);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        } finally {
            context.consoleService().close();
        }
    }
}
