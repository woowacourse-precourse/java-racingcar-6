package racingcar.domain.referee;

public class InGameReferee {
    private final int LOWER_LIMIT = 4;

    public boolean isBiggerLowerLimit(int generatedNumber) {
        return generatedNumber >= LOWER_LIMIT;
    }
}
