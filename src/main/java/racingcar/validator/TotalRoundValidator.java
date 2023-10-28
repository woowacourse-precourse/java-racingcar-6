package racingcar.validator;

public class TotalRoundValidator implements Validator {
    @Override
    public void validate(String totalRound) {
        if (isBlank(totalRound) || isNotNumeric(totalRound)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotNumeric(String totalRound) {
        return !totalRound.chars()
                .allMatch(Character::isDigit);
    }

    private boolean isBlank(String totalRound) {
        return totalRound == null || totalRound.isBlank();
    }
}
