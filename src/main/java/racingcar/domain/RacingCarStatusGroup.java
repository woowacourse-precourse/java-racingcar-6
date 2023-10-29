package racingcar.domain;

import java.util.List;

import static racingcar.handler.ErrorHandler.MAX_VALUE_MISSING;

public class RacingCarStatusGroup {

    private final List<RacingCarStatus> racingCarStatusList;

    public RacingCarStatusGroup(List<RacingCarStatus> racingCarStatusList) {
        this.racingCarStatusList = racingCarStatusList;
    }

    public void moveForward() {
        for (RacingCarStatus racingCarStatus : racingCarStatusList) {
            RandomNumber randomNumber = new RandomNumber();

            if (randomNumber.isMovePossible()) {
                racingCarStatus.forWard();
            }
        }
    }

    public List<RacingCarStatus> getFinishCarList() {
        return List.copyOf(racingCarStatusList);
    }

    private RacingCarStatus getMaxPosition() {
        return racingCarStatusList.stream()
                .max(RacingCarStatus::compareTo)
                .orElseThrow(() -> MAX_VALUE_MISSING.getException());
    }
}
