package racingcar.properties;

import racingcar.playrule.RacingRule;
import racingcar.racingcar.RacingParticipants;

/**
 * @author 민경수
 * @description racing property
 * @since 2023.10.30
 **********************************************************************************************************************/
public class RacingProperty {

    private final RacingParticipants racingParticipants;
    private final int moveChanceCount;
    private final RacingRule racingRule;

    public RacingProperty(RacingParticipants racingParticipants, String moveChanceCount, RacingRule racingRule) {
        this.racingParticipants = racingParticipants;

        int number = convertToInteger(moveChanceCount);
        validateMoveChanceCount(number);
        this.moveChanceCount = number;

        this.racingRule = racingRule;
    }

    public int moveChanceCount() {
        return moveChanceCount;
    }

    public RacingRule racingRule() {
        return racingRule;
    }

    public RacingParticipants racingParticipants() {
        return racingParticipants;
    }

    private int convertToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력한 값을 확인해주세요. 값 : " + number);
        }
    }

    private void validateMoveChanceCount(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }
    }

}