package racingcar;

import java.util.List;
import racingcar.common.factory.GameComponentFactory;
import racingcar.common.strategy.MoveStrategy;
import racingcar.common.type.Names;
import racingcar.common.type.TrialCount;
import racingcar.controller.Game;
import racingcar.controller.Racing;
import racingcar.controller.Result;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingWinners;
import racingcar.dto.input.InputDTO;
import racingcar.view.InputView;

public class GameLauncher {
    public static void run() {
        //사용자 입력
        InputDTO userInput = getUserInput();

        //각종 객체 초기화
        List<Car> carList = generateCars(userInput);
        MoveStrategy moveStrategy = initializeMoveStrategy();
        Game game = initializeGame(carList, moveStrategy);
        Result result = initializeResult(carList);
        Racing racing = startRacing(game, result);

        //레이싱 시작
        TrialCount trialCount = userInput.trialCount();
        racing.start(trialCount);
    }

    private static MoveStrategy initializeMoveStrategy() {
        return GameComponentFactory.createMoveStrategy();
    }

    private static InputDTO getUserInput() {
        return InputView.readUserInput();
    }

    private static List<Car> generateCars(InputDTO userInput) {
        Names names = userInput.names();
        return GameComponentFactory.createCarList(names);
    }

    private static Game initializeGame(List<Car> carList, MoveStrategy moveStrategy) {
        RacingCars racingCars = GameComponentFactory.createRacingCars(carList, moveStrategy);

        return GameComponentFactory.createGame(racingCars);
    }

    private static Result initializeResult(List<Car> carList) {
        RacingWinners racingWinners = GameComponentFactory.createRacingWinners(carList);
        return GameComponentFactory.createResult(racingWinners);
    }

    private static Racing startRacing(Game game, Result result) {
        return GameComponentFactory.createRacing(game, result);
    }
}
