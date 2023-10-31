package racingcar.underhood;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.underhood.NumberOfRepetitions;

public class GameRule {

    private int minNumberInclude;
    private int maxNumberInclude;
    private int numberOfRepetitions;
    private static final Pattern validCarNamePattern = Pattern.compile("^[a-z, A-Z, 0-9]{1,5}$");
    private static final Pattern validNumberOfRepetitionsPattern
            = Pattern.compile("^0*[1-9]+\\d*$");

    public GameRule(int minInclude, int maxInclude) {
        this.minNumberInclude = minInclude;
        this.maxNumberInclude = maxInclude;
    }


    public int getMinNumberInclude() {
        return this.minNumberInclude;
    }

    public int getMaxNumberInclude() {
        return this.maxNumberInclude;
    }

    public int getNumberOfRepetitions() {
        return numberOfRepetitions;
    }

    public void validateCarName(String input) throws IllegalArgumentException {
        throwExceptionIfNotValid(input, validCarNamePattern);
    }

    public void validateNumberOfRepetitions(String input) throws IllegalArgumentException {
        throwExceptionIfNotValid(input, validNumberOfRepetitionsPattern);
    }

    public void setNumberOfRepetitions(NumberOfRepetitions numBerOfRepetitions) {
        this.numberOfRepetitions = numBerOfRepetitions.getN();
    }

    private void throwExceptionIfNotValid(String input, Pattern expected)
            throws IllegalArgumentException {
        Matcher matcher = expected.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }
}
