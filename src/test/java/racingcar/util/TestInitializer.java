package racingcar.util;

import java.util.List;
import racingcar.common.type.Names;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingWinners;

public class TestInitializer {

    // 모든 초기화 로직을 한 번에 수행하는 public 메서드
    public static void initializeAll(TestContext context) {
        Names names = initNames();
        List<Car> carList = initCarList(names);
        RacingCars racingCars = initRacingCars(carList);
        RacingWinners racingWinners = initRacingWinners(carList);

        context.setRacingCars(racingCars);
        context.setRacingWinners(racingWinners);
    }

    private static Names initNames() {
        return Names.of(new String[]{"hyunjin", "pobi", "lefthand"});
    }

    private static List<Car> initCarList(Names names) {
        return Car.createCarList(names);
    }

    private static RacingCars initRacingCars(List<Car> carList) {
        return RacingCars.of(carList, () -> true);
    }

    private static RacingWinners initRacingWinners(List<Car> carList) {
        return RacingWinners.of(carList);
    }
}
