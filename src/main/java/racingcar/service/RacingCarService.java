package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarEngine;
import racingcar.domain.Cars;
import racingcar.domain.RacingResult;
import racingcar.domain.RacingRoundResult;

public class RacingCarService {
    private final RacingCarAssemblyService racingCarAssemblyService;
    private final CarEngine carEngine;

    public RacingCarService(RacingCarAssemblyService racingCarAssemblyService, CarEngine carEngine) {
        this.racingCarAssemblyService = racingCarAssemblyService;
        this.carEngine = carEngine;
    }

    public RacingResult race(List<String> carNames, int attemptCounts) {
        Cars cars = racingCarAssemblyService.assemble(carNames, carEngine);
        RacingResult racingResult = new RacingResult();
        for (int i = 0; i < attemptCounts; i++) {
            cars.move();
            List<Car> readOnlyCarList = cars.getReadOnlyCarList();
            RacingRoundResult racingRoundResult = new RacingRoundResult(readOnlyCarList);
            racingResult.addResult(racingRoundResult);
        }
        return racingResult;
    }

    public List<String> determineWinner(RacingResult racingResult) {
        return racingResult.getFinalWinners();
    }
}
