package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class ThresholdRandomMover implements MovingStrategy {

    private final int minRandomBound;
    private final int maxRandomBound;
    private final int movingThreshold;

    public ThresholdRandomMover(int minRandomBound,
                                int maxRandomBound,
                                int movingThreshold) {
        this.minRandomBound = minRandomBound;
        this.maxRandomBound = maxRandomBound;
        this.movingThreshold = movingThreshold;
    }

    @Override
    public boolean isMovable() {
        return Randoms.pickNumberInRange(minRandomBound, maxRandomBound) >= movingThreshold;
    }
}
