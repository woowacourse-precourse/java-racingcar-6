package racingcar.model;

public enum ActionType {

    GO(1), STOP(0);

    private Integer action;

    ActionType(Integer action) {
        this.action = action;
    }

    public Integer getAction() {
        return action;
    }
}
