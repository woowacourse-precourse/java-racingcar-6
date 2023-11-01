package racingcar.util;

public class RaceValidate {
    public static int checkRaceNumber(String number) {
        checkInteger(number);
        return Integer.parseInt(number);
    }

    private static void checkInteger(String number) {
        try {
           int n = Integer.parseInt(number);
           checkNaturalNumber(n);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 숫자를 입력해야 합니다.");
        }
    }

    private static void checkNaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[Error] 0보다 큰 값을 입력해야 합니다.");
        }
    }



}
