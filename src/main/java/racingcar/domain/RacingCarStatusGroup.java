package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getWinnerNames(RacingCarStatus maxPositionCar) {
        return racingCarStatusList.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(RacingCarStatus::getCarName)
                .collect(Collectors.toUnmodifiableList());
    }

    public RacingCarStatus getMaxPosition() {
        return racingCarStatusList.stream()
                .max(RacingCarStatus::compareTo)
                .orElseThrow(() -> MAX_VALUE_MISSING.getException());
    }
}
