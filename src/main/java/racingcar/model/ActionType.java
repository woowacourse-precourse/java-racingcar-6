package racingcar.model;

import racingcar.util.RandomNumberGenerator;

public enum ActionType {

    GO(1), STOP(0);

    private static final Integer THRESHOLD = 4;
    
    private Integer action;

    ActionType(Integer action) {
        this.action = action;
    }

    public static Integer randomAction() {
        Integer randomNumber = RandomNumberGenerator.pickNumber();
        if (randomNumber >= THRESHOLD) {
            return GO.getAction();
        }
        return STOP.getAction();
    }

    public Integer getAction() {
        return action;
    }
}
