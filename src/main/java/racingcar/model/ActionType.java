package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public enum ActionType {

    GO(1), STOP(0);

    private static final Integer FIRST_NUMBER = 0;
    private static final Integer LAST_NUMBER = 9;
    private static final Integer THRESHOLD = 4;

    private Integer action;

    ActionType(Integer action) {
        this.action = action;
    }

    public static Integer getRandomAction() {
        Integer randomNumber = Randoms.pickNumberInRange(FIRST_NUMBER, LAST_NUMBER);
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
