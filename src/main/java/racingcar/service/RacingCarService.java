package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.CarEngine;
import racingcar.domain.Cars;
import racingcar.domain.RacingResult;
import racingcar.domain.RacingRoundResult;
import racingcar.dto.CarInfo;

public class RacingCarService {
    private final CarEngine carEngine;

    public RacingCarService(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    public RacingResult race(List<String> carNames, int attemptCounts) {
        Cars cars = Cars.assemble(carNames, this.carEngine);
        RacingResult racingResult = new RacingResult();
        for (int i = 0; i < attemptCounts; i++) {
            cars.move();
            List<CarInfo> carInfoList = getCarInfoList(cars);
            racingResult.addResult(new RacingRoundResult(carInfoList));
        }
        return racingResult;
    }

    private static List<CarInfo> getCarInfoList(Cars cars) {
        return cars.getReadOnlyCarList().stream()
                .map(CarInfo::of)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> determineWinner(RacingResult racingResult) {
        return racingResult.getFinalWinners();
    }
}
