package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private static final int START_DISTANCE = 0;
    private static final int MINIMUM_RANDOM_NUMBER_TO_MOVE = 4;

    private int distance;

    public RacingCar() {
        this.distance = START_DISTANCE;
    }

    /**
     * 라운드를 진행한다.
     */
    public void excuteRound() {
        boolean movable = isMovable();
        if (movable) {
            moveForward();
        }
        if (!movable) {
            stop();
        }
    }

    /**
     * 전진을 할 조건이다.
     *
     * @return 전진해야하면 true 정지해야하면 false
     */
    private boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        return randomNumber >= MINIMUM_RANDOM_NUMBER_TO_MOVE;
    }

    /**
     * 1칸 전진한다.
     */
    private void moveForward() {
        distance++;
    }

    /**
     * 정지해 있는다.
     */
    private void stop() {

    }

    /**
     * 지금 음직인 거리를 알려준다.
     *
     * @return 지금까지 음직인 거리
     */
    public int getDistance() {
        return distance;
    }
}
