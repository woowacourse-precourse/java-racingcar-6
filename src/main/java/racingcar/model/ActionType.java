package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public enum ActionType {

    GO(1), STOP(0);

    private static final Integer MIN_NUMBER = 0;
    private static final Integer MAX_NUMBER = 9;
    private static final Integer THRESHOLD = 4;

    private Integer action;

    ActionType(Integer action) {
        this.action = action;
    }

    public static Integer randomAction() {
        Integer randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (randomNumber >= THRESHOLD) {
            return move();
        }
        return stop();
    }

    private static Integer move() {
        return GO.getAction();
    }

    private static Integer stop() {
        return STOP.getAction();
    }

    private Integer getAction() {
        return action;
    }
}
