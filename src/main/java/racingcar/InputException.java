package racingcar;

public class InputException {

    private static Integer saveTrialNumber(String trialNumberInput) {
        try {
            Integer trialNumber = Integer.valueOf(trialNumberInput);
            return trialNumber;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }
    public static void isCorrectNameLength(String carName) {
        if ( carName.isEmpty() || carName.length() > 5 ) {
            throw new IllegalArgumentException("이름의 길이를 5자 이하로 설정해주세요");
        }
    }
    public static void isContainComma(String carNames) {
        if (!carNames.contains(",") ) {
            throw new IllegalArgumentException("여러 대의 자동차를 쉼표로 입력해주세요");
        }
    }

}
