package racingcar;

public class Exception {

    public static void checkOverWriteUserName(String[] userName) {
        for (int i = 0; i < userName.length; i++) {
            if (userName[i].length() > 5) {
                throw new IllegalArgumentException("프로그램을 종료합니다.");
            }
        }
    }


    public static void checkOnlyNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if ((number.charAt(i)) > '9'|| number.charAt(i)< '0') {
                throw new IllegalArgumentException("프로그램을 종료합니다.");
            }
        }
    }

    public static void ifUserZeroNumber(String number) {
        if (number.charAt(0) == '0') {
            throw new IllegalArgumentException("프로그램을 종료합니다.");
        }
    }
}

