package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.dto.RaceStatus;
import racingcar.dto.RacingGameResult;
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
        List<RaceStatus> raceStatuses = loggingRaceStatuses(raceCount);
        WinnerNames winnerNames = cars.getWinnerNames();

        return new RacingGameResult(raceStatuses, winnerNames);
    }

    private List<RaceStatus> loggingRaceStatuses(int raceCount) {
        return IntStream.range(0, raceCount)
                .mapToObj(cnt -> cars.driveCarsByRule(RacingGame::raceRule))
                .toList();
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
