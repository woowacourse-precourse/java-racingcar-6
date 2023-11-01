package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.dto.RaceStatus;
import racingcar.dto.RacingGameResult;
import racingcar.dto.RacingGameStatus;
import racingcar.dto.WinnerNames;
import racingcar.exception.RaceCountLessThanOneException;

public class RacingGame {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int DRIVE_MIN_NUMBER = 4;
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public RacingGameResult race(int raceCount) {
        verifyRaceCount(raceCount);
        List<RaceStatus> raceStatuses = IntStream.range(0, raceCount)
                .mapToObj(cnt -> cars.driveCarsByRule(RacingGame::raceRule))
                .toList();

        RacingGameStatus racingGameStatus = new RacingGameStatus(raceStatuses);
        WinnerNames winnerNames = cars.getWinnerNames();

        return new RacingGameResult(racingGameStatus, winnerNames);
    }

    private void verifyRaceCount(int raceCount) {
        if (raceCount < 1) {
            throw new RaceCountLessThanOneException();
        }
    }

    private static boolean raceRule() {
        int randomNumber = pickNumberInRange(START_NUMBER, END_NUMBER);
        return DRIVE_MIN_NUMBER <= randomNumber;
    }
}
