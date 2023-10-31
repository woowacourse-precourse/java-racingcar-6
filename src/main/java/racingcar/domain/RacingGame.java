package racingcar.domain;

import racingcar.domain.dto.RaceResult;
import racingcar.domain.dto.RoundResult;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(List<String> carNames) {
        this.cars = new Cars(carNames);
    }

    public RaceResult start(int round) {
        List<RoundResult> roundResultList = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            RoundResult roundResult = cars.race();

            roundResultList.add(roundResult);
        }
        return RaceResult.of(roundResultList);
    }
}
