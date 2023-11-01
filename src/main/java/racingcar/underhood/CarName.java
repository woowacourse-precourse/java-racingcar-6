package racingcar.underhood;

import racingcar.common.UserInputWrapper;

public class CarName
        extends RacingGameComponent implements UserInputWrapper {

    private String name;

    public CarName(GameRule rule, String input) throws IllegalArgumentException {
        super(rule);
        validate(input);
        this.name = input;
    }

    @Override
    public void validate(String input) throws IllegalArgumentException {
        this.rule.validateCarName(input);
    }


    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != CarName.class) {
            return false;
        }
        return this.name.equals(((CarName) obj).name);
    }
}
