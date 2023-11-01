package racingcar.domain;

public class RoundValidator {
    public RoundValidator() {
    }

    public static int validate(String number) {
        int naturalNumber = checkNaturalNumber(number);
        isUnderTwenty(naturalNumber);
        return naturalNumber;
    }

    public static int checkNaturalNumber(String number) {
        try {
            int naturalNumber = Integer.parseInt(number);
            return naturalNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력하여 게임을 종료합니다.");
        }
    }

    public static void isUnderTwenty(int number) {
        if (number < 1 || number > 20) {
            throw new IllegalArgumentException("잘못된 값을 입력하여 게임을 종료합니다. (최대 20회까지 가능합니다.)");
        }
    }
}
