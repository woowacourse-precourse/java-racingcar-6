package racingcar.common.factory;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.generator.NsRandomGenerator;
import racingcar.common.strategy.MoveStrategy;
import racingcar.common.type.Names;
import racingcar.common.type.TrialCount;
import racingcar.controller.Game;
import racingcar.controller.Racing;
import racingcar.controller.Result;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingWinners;

public class ConstructorFactory {
    // 자동차 리스트 생성
    public static List<Car> createCarList(Names names) {
        return names.getNameList()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    // 움직임 전략 생성
    public static MoveStrategy createMoveStrategy() {
        NsRandomGenerator randomGenerator = new NsRandomGenerator();
        return new MoveStrategy(randomGenerator);
    }

    public static RacingCars createRacingCars(List<Car> carList) {
        return new RacingCars(carList);
    }

    public static RacingWinners createRacingWinners(List<Car> carList) {
        return new RacingWinners(carList);
    }

    public static Game createGame(RacingCars racingCars, MoveStrategy moveStrategy, TrialCount trialCount) {
        return new Game(racingCars, moveStrategy, trialCount);
    }

    public static Result createResult(RacingWinners racingWinners) {
        return new Result(racingWinners);
    }

    public static Racing createRacing(Game game, Result result) {
        return new Racing(game, result);
    }
}
