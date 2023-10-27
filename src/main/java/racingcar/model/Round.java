package racingcar.model;

public class Round {

    public static final String ONLY_NUMBER = "^[0-9]+";
    private Integer round;

    //TODO: 타입이 달라달라 어떻게 할래?
    public Round(String round) {
        validate(round);
        this.round = Integer.parseInt(round);
    }

    //TODO: 진행중인지 확인하는 것 뿐만 아니라 감소까지 함. 고쳐보자
    public Boolean isContinue() {
        if (round > 0) {
            round--;
            return true;
        }
        return false;
    }

    private void validate(String value) {
        validateType(value);
        validateRange(value);
    }

    private void validateType(String value) {
        if (value != null && !value.matches(ONLY_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(String value) {
        if (0 >= Integer.parseInt(value)) {
            throw new IllegalArgumentException();
        }
    }
}
