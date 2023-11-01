package racingcar.race;

public class NumberTimeTryExceptionProcessing {

    private static final String NUMBER_RANGE = "시도할 회수의 범위는 1 ~ 2_147_483_646 입니다.";

    public static int checkNumber(int numberTimeTry) {

        checkNumberRange(numberTimeTry);
        return numberTimeTry;

    }

    private static void checkNumberRange(int numberTimeTry) {

        if (numberTimeTry < 1 || numberTimeTry > 2_147_483_646) {
            throw new IllegalArgumentException(NUMBER_RANGE);
        }

    }
}
