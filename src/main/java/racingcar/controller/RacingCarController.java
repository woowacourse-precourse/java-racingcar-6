package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.service.RacingCarServiceImpl;
import racingcar.util.RacingCarVO;

public class RacingCarController {

    private static final RacingCarService racingCarService = new RacingCarServiceImpl();

    public void racingCar() {

        System.out.println(RacingCarVO.getStartSentence());

        List<Car> carList = racingCarService.createCarList();

        System.out.println(RacingCarVO.getAttemptCount());

        int attemptCount = racingCarService.getAttemptCount();

        System.out.println(RacingCarVO.getExecutionResult());

        for (int i = 0; i < attemptCount; i++) {
            racingCarService.moveCars(carList);
            racingCarService.printMovementCounts(carList);
        }

        racingCarService.announceWinner(carList);
    }
}
