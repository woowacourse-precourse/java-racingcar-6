package racingcar;

import java.util.List;
import racingcar.common.strategy.MoveStrategy;
import racingcar.common.type.Names;
import racingcar.common.type.TrialCount;
import racingcar.common.factory.ConstructorFactory;
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
        //사용자 입력 생성
        InputDTO inputDTO = InputView.readUserInput();

        //자동차 리스트 생성
        Names names = inputDTO.names();
        List<Car> carList = createCarList(names);

        //게임 객체 생성
        TrialCount trialCount = inputDTO.trialCount();
        Game game = createGame(carList, trialCount);

        //게임 결과 객체 생성
        Result result = createResult(carList);

        //레이싱 객체 생성 및 게임 시작
        Racing racing = createRacing(game, result);
        racing.start();
    }

    private static List<Car> createCarList(Names names) {
        return ConstructorFactory.createCarList(names);
    }

    private static MoveStrategy createMoveStrategy() {
        return ConstructorFactory.createMoveStrategy();
    }

    private static Game createGame(List<Car> carList, TrialCount trialCount) {
        MoveStrategy moveStrategy = createMoveStrategy();
        RacingCars racingCars = ConstructorFactory.createRacingCars(carList);
        return ConstructorFactory.createGame(racingCars, moveStrategy, trialCount);
    }

    private static Result createResult(List<Car> carList) {
        RacingWinners racingWinners = ConstructorFactory.createRacingWinners(carList);
        return ConstructorFactory.createResult(racingWinners);
    }

    private static Racing createRacing(Game game, Result result) {
        return ConstructorFactory.createRacing(game, result);
    }
}
