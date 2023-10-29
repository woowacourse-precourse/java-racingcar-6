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

    public int getMaxPosition() {
        return racingCarStatusList.stream()
                .mapToInt(RacingCarStatus::getPosition)
                .max()
                .orElseThrow(() -> MAX_VALUE_MISSING.getException());
    }
}
