package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfRepetitions
        extends RacingGameComponent implements UserInputWrapper {

    private int n;

    public NumberOfRepetitions(int n) {
        this.n = n;
    }

    public NumberOfRepetitions(String input) throws IllegalArgumentException {
        validate(input);
        this.n = Integer.parseInt(input);
    }

    public int getN() {
        return this.n;
    }

    @Override
    public void validate(String input) throws IllegalArgumentException {
        Pattern patter = Pattern.compile("^0*[1-9]+\\d*$");
        Matcher matcher = patter.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != NumberOfRepetitions.class) {
            return false;
        }
        return ((NumberOfRepetitions) obj).n == this.n;
    }
}
