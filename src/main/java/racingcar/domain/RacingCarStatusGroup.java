package racingcar.domain;

import java.util.List;

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
}
