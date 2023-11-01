package racingcar.util;

public class ValidationManager {

    // 입력된 이름들이 5자 미만인지 validate 하는 메서드.
    public static void validateCarNames(String[] names) {
        for (String name : names) {
            if (name.trim().length() > 5 || name.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }

    // 시도 횟수가 정수인지, 맞다면 음수가 아닌지 validate 하는 메서드.
    public static void validateTrials(String trialInput) {
        try {
            int trials = Integer.parseInt(trialInput);
            if (trials <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
