package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public enum Status {

    GO(1), STOP(0);

    private static final Integer FIRST_NUMBER = 0;
    private static final Integer LAST_NUMBER = 9;
    private static final Integer THRESHOLD = 4;

    private Integer forward;

    Status(Integer forward) {
        this.forward = forward;
    }

    public static Integer change() {
        Integer randomNumber = Randoms.pickNumberInRange(FIRST_NUMBER, LAST_NUMBER);
        if (randomNumber >= THRESHOLD) {
            return move();
        }
        return stop();
    }

    private static Integer move() {
        return GO.getForward();
    }

    private static Integer stop() {
        return STOP.getForward();
    }

    private Integer getForward() {
        return forward;
    }
}
