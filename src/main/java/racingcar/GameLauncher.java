package racingcar;

import java.util.List;
import racingcar.common.factory.ConstructorFactory;
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
        InputDTO userInput = getUserInput();
        List<Car> carList = generateCars(userInput);
        Game game = initializeGame(carList, userInput);
        Result result = initializeResult(carList);
        Racing racing = startRacing(game, result);

        racing.start();
    }

    private static InputDTO getUserInput() {
        return InputView.readUserInput();
    }

    private static List<Car> generateCars(InputDTO userInput) {
        Names names = userInput.names();
        return ConstructorFactory.createCarList(names);
    }

    private static Game initializeGame(List<Car> carList, InputDTO userInput) {
        MoveStrategy moveStrategy = createMoveStrategy();
        RacingCars racingCars = ConstructorFactory.createRacingCars(carList);
        TrialCount trialCount = userInput.trialCount();

        return ConstructorFactory.createGame(racingCars, moveStrategy, trialCount);
    }

    private static Result initializeResult(List<Car> carList) {
        RacingWinners racingWinners = ConstructorFactory.createRacingWinners(carList);
        return ConstructorFactory.createResult(racingWinners);
    }

    private static Racing startRacing(Game game, Result result) {
        return ConstructorFactory.createRacing(game, result);
    }

    private static MoveStrategy createMoveStrategy() {
        return ConstructorFactory.createMoveStrategy();
    }
}
