package racingcar.underhood;

import racingcar.common.UserInputWrapper;

public class NumberOfRepetitions
        extends RacingGameComponent implements UserInputWrapper {

    private int n;

    public NumberOfRepetitions(GameRule rule, int n) {
        super(rule);
        this.n = n;
    }

    public NumberOfRepetitions(GameRule rule, String input) throws IllegalArgumentException {
        super(rule);
        this.rule.validateNumberOfRepetitions(input);
        this.n = Integer.parseInt(input);
    }

    public int getN() {
        return this.n;
    }

    @Override
    public void validate(String input) throws IllegalArgumentException {
        this.validate(input);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != NumberOfRepetitions.class) {
            return false;
        }
        return ((NumberOfRepetitions) obj).n == this.n;
    }
}
