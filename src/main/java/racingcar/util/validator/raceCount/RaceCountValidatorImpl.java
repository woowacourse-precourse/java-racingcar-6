package racingcar.util.validator.raceCount;

public class RaceCountValidatorImpl implements RaceCountValidator {
    @Override
    public boolean validateRaceCount(String input) {
        return isNumeric(input);
    }

    private boolean isNumeric(String input) {
        String regex = "^[0-9]+$";
        return input.matches(regex);
    }
}
