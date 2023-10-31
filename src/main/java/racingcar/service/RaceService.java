package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingManager;
import racingcar.view.dto.CarNameList;
import racingcar.service.dto.GameResult;
import racingcar.domain.RandomNumberGenerator;
import racingcar.service.dto.TotalGameResult;

public class RaceService {

    private final RandomNumberGenerator randomNumberGenerator;

    public RaceService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public TotalGameResult doGame(CarNameList carNames, String attemptNumberString) {
        RacingManager racingManager = new RacingManager(carNames);
        int attemptNumber = convertToInt(attemptNumberString);

        List<GameResult> results = doMainContent(racingManager, attemptNumber);

        return new TotalGameResult(results, racingManager.calculateWinner());
    }

    private List<GameResult> doMainContent(RacingManager racingManager, int attemptNumber) {
        List<GameResult> results = new ArrayList<>();
        for (int i = 0; i < attemptNumber; i++) {
            racingManager.moveEach(
                    randomNumberGenerator.generateNumbers(
                            racingManager.size()
                    )
            );
            results.add(racingManager.createResult());
        }
        return results;
    }

    private int convertToInt(String attemptNumberString) {
        try {
            return Integer.parseInt(attemptNumberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
