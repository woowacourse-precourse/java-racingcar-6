package racingcar.domain;

public class Validator {
    private Validator(){

    }

    public static boolean isValidCarName(String name) {
        return !(name.length() >= 1 && name.length() <= 5);
    }

    public static boolean isEmpty(String carNames){
        return carNames.trim().isEmpty();
    }

    public static boolean isNotNumber(String round){
        try {
            Integer.parseInt(round);   // 문자열을 정수로 변환 시도

        } catch (NumberFormatException e) {     // 변환 중 예외 발생: 유효하지 않은 숫자 입력
            return true;
        }
        return false;
    }
}
