package racingcar.model;

import racingcar.utils.NumberGenerator;

public class GameRule {

    private final int STANDARD_NUMBER = 4;
    private final int STANDARD_NAME_SIZE = 5;
    private NumberGenerator numberGenerator;

    public GameRule(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    protected boolean isOkToMove() {
        int RANDOM_NUMBER = numberGenerator.generateNumberInRange();

        if(RANDOM_NUMBER < STANDARD_NUMBER) {
            return false;
        }
        return true;
    }

    protected boolean isOkToUseCarName(String carName) {
        if(carName.length() > STANDARD_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다!");
        }
        return true;
    }

    protected boolean isOkToUseAttemptCount(int attemptCount) {
        try{
            int count = attemptCount;
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 시도 횟수를 입력하지 않았습니다.");
        }
    }
}
