package racingcar.domain.entity;

import racingcar.dto.RaceResponse;

public class RaceEntity {
    private final int attemptNumber;

    public RaceEntity(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }
}
