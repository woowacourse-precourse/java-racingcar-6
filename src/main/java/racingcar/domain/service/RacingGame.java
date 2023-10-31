package racingcar.domain.service;

import java.util.List;
import racingcar.domain.dto.RacingCarProgressDTO;
import racingcar.domain.dto.RacingCarWinnerDTO;
import racingcar.domain.model.Cars;

public class RacingGame {
    private final Cars cars;
    private final RandomMoveJudge randomMoveJudicator;

    public RacingGame(Cars cars, RandomMoveJudge randomMoveJudicator) {
        this.cars = cars;
        this.randomMoveJudicator = randomMoveJudicator;
    }


    public void advance() {
        cars.moveAll(randomMoveJudicator);
    }

    public RacingCarWinnerDTO determineWinner() {
        Cars winners = cars.findTopPositionCars();
        return new RacingCarWinnerDTO(winners.formatNames());
    }

    public RacingCarProgressDTO getProgressStatus() {
        List<String> carsProgress = cars.progressStatusFormat();
        return new RacingCarProgressDTO(carsProgress);
    }

}
