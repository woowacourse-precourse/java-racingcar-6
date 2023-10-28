package racingcar.util.validator.raceCount;

public class RaceCountValidatorImpl implements RaceCountValidator {
    @Override
    public boolean validateRaceCount(String input) {
        return isNonNegative( parseInt(input) );
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            return -1;
        }
    }

    private boolean isNonNegative(int number) {
        return number >= 0;
    }
}
