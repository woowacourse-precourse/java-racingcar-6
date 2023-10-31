package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.CarList;
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
        CarList carList = new CarList(carNames);
        int attemptNumber = convertToInt(attemptNumberString);

        List<GameResult> results = doMainContent(carList, attemptNumber);

        return new TotalGameResult(results, carList.calculateWinner());
    }

    private List<GameResult> doMainContent(CarList carList, int attemptNumber) {
        List<GameResult> results = new ArrayList<>();
        for (int i = 0; i < attemptNumber; i++) {
            carList.moveEach(
                    randomNumberGenerator.generateNumbers(
                            carList.size()
                    )
            );
            results.add(carList.createResult());
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
