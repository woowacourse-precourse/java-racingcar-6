package racingcar.domain;

public class Judgment {

    private static final int FORWARD_CONDITION = 4;

    public boolean isNumberFourOrMore(int number) {
        return number >= FORWARD_CONDITION;
    }
}
