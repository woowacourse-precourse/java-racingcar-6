package racingcar.util;

public class Validation {
    private static final int MAX_NAME_LENGTH = 5;

    public static void checkCarName(String carName) throws IllegalArgumentException {
        if(carName.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 5자 이하로 작성해주세요.");
        }
    }

    public static void checkTryNumber(String tryNum) throws IllegalArgumentException {
        try {
            Integer.parseInt(tryNum);
        }catch (NumberFormatException ex) {
            throw new IllegalArgumentException("숫자가 아닌 다른 문자를 입력하셨습니다.");
        }
    }
}
