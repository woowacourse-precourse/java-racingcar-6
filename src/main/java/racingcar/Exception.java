package racingcar;

public class Exception {

    public static void checkOverWriteUserName(String[] userName) {
        for (int i = 0; i < userName.length; i++) {
            if (userName.length > 5) {
                throw new IllegalArgumentException("프로그램을 종료합니다.");
            }
        }
    }
}
