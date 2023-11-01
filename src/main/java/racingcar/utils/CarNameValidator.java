package racingcar.utils;

public class CarNameValidator {
    public static boolean isPossibleNameLength(String carNameLength){
        // 5자 이하 이름
        if (carNameLength.length() > 5) {
            return true;
        }
        return false;
    }
}
