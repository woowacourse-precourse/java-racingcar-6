package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingGame {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int DRIVE_MIN_NUMBER = 4;
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void race(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            cars.doRace(RacingGame::raceRule);
        }
    }

    private static boolean raceRule() {
        int randomNumber = pickNumberInRange(START_NUMBER, END_NUMBER);
        return DRIVE_MIN_NUMBER <= randomNumber;
    }
}
