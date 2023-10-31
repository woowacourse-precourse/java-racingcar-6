package racingcar.domain;

public class RoundValidator {
    public RoundValidator() {
    }

    public static int checkNaturalNumber(String number) {
        int naturalNumber;
        try {
            naturalNumber = Integer.parseInt(number);
            if (naturalNumber < 1 || naturalNumber > 10) {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력하여 게임을 종료합니다.");
        }
        return naturalNumber;
    }
}
