package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int DRIVE_MIN_NUMBER = 4;
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public RacingGameStatus race(int raceCount) {
        verifyRaceCount(raceCount);
        List<RaceStatus> raceStatuses = IntStream.range(0, raceCount)
                .mapToObj(cnt -> cars.driveCarsByRule(RacingGame::raceRule))
                .toList();

        return new RacingGameStatus(raceStatuses);
    }

    private void verifyRaceCount(int raceCount) {
        if (raceCount < 1) {
            throw new IllegalArgumentException("최소 한 번의 경주는 진행되어야 합니다.");
        }
    }

    private static boolean raceRule() {
        int randomNumber = pickNumberInRange(START_NUMBER, END_NUMBER);
        return DRIVE_MIN_NUMBER <= randomNumber;
    }

    public WinnerNames getWinnerNames() {
        return cars.getWinnerNames();
    }
}
