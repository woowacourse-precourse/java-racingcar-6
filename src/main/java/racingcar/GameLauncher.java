package racingcar;

import java.util.List;
import racingcar.common.strategy.MoveStrategy;
import racingcar.common.type.Names;
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
        InputDTO userInput = InputView.readUserInput();

        Racing racing = initializeRacingGame(userInput);

        racing.start(userInput.getTrialCount());
    }

    private static Racing initializeRacingGame(InputDTO userInput) {
        //자동자 리스트 생성 및 움직임 전략 생성
        List<Car> carList = createCarList(userInput.getNames());
        MoveStrategy moveStrategy = initializeMoveStrategy();

        //도메인 객체(일급 컬렉션) 생성
        RacingCars racingCars = createRacingCars(carList, moveStrategy);
        RacingWinners racingWinners = createRacingWinners(carList);

        //레이싱 객체 생성
        return createRacing(racingCars, racingWinners);
    }

    private static List<Car> createCarList(Names names) {
        return Car.createCarList(names);
    }

    private static MoveStrategy initializeMoveStrategy() {
        return MoveStrategy.of();
    }

    private static RacingCars createRacingCars(List<Car> carList, MoveStrategy moveStrategy) {
        return RacingCars.of(carList, moveStrategy);
    }

    private static RacingWinners createRacingWinners(List<Car> carList) {
        return RacingWinners.of(carList);
    }

    private static Racing createRacing(RacingCars racingCars, RacingWinners racingWinners) {
        Game game = Game.of(racingCars);
        Result result = Result.of(racingWinners);
        return Racing.of(game, result);
    }
}
