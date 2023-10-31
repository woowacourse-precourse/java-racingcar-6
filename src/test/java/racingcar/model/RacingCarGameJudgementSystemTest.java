package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarGameJudgementSystemTest {

    @Test
    public void judge() {
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(carNames);

        CarAccelerator carAccelerator = new CarAccelerator();
        carAccelerator.setFakeRandoms();

        cars.attemptToMoveCars(carAccelerator);
        cars.attemptToMoveCars(carAccelerator);
        cars.attemptToMoveCars(carAccelerator);

        RacingCarGameJudgementSystem racingCarGameJudgementSystem = new RacingCarGameJudgementSystem();
        Winners winners = racingCarGameJudgementSystem.judge(cars);

        List<String> winnerNames = winners.getWinnerNames();
        assertEquals(carNames, winnerNames);
    }
}