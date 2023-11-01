package racingcar.Validator;

public class TrialCountValidator {
    public static int validateTrialCount(String trialCountInput) {
        try {
            int trialCount = Integer.parseInt(trialCountInput);

            if (trialCount < 0) {
                throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
            }
            return trialCount;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

}
