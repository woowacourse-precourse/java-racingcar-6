package racingcar.constant.rule;

public enum ParticipantRule {
    MINIMUM_PARTICIPANTS(2);

    private final int value;

    ParticipantRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
