package domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class RacingGameStartManager {
    private static final int RACING_CAR_MAX_LENGTH = 5;
    private static final int RACING_CAR_MIN_LENGTH = 1;

    // 경주에 참여할 자동차 Set 생성
    public Set<RacingCar> createRacingCarSet(String[] inputRacingCarNames) {
        Set<RacingCar> racingCarSet = new LinkedHashSet<>();

        for (String racingCarName : inputRacingCarNames) {
            validateRacingCarName(racingCarName, racingCarSet);
            racingCarSet.add(new RacingCar(racingCarName, 0));
        }

        return racingCarSet;
    }

    private void validateRacingCarName(String racingCarName, Set<RacingCar> racingCarSet) {
        if (!isRacingCarNameLengthInRange(racingCarName)) {
            throw new IllegalArgumentException(
                    "자동차 이름은 " + RACING_CAR_MAX_LENGTH + "자 이상 " + RACING_CAR_MAX_LENGTH + "자 이하만 입력 가능합니다."
            );
        } else if (!isRacingCarNameUnique(racingCarName, racingCarSet)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private boolean isRacingCarNameLengthInRange(String racingCarName) {
        return (racingCarName.length() >= RACING_CAR_MIN_LENGTH) && (racingCarName.length() <= RACING_CAR_MAX_LENGTH);
    }

    private boolean isRacingCarNameUnique(String racingCarName, Set<RacingCar> racingCarSet) {
        return racingCarSet.stream()
                .map(RacingCar::getName)
                .noneMatch(name -> name.equals(racingCarName));
    }
}
