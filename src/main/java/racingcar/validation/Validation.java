package racingcar.validation;

public class Validation {

    public static void validNames(String names){
        int i = 0;
        boolean prevComma = false;

        while (i < names.length()){
            if (names.charAt(i) == ','){
                if (prevComma) {
                    throw new IllegalArgumentException("잘못된 입력입니다. (연속된 ',')");
                }
                prevComma = true;
                i++;
                continue;
            }
            prevComma = false;
            i++;
        }
    }

    public static void validCount(String count){
        int i = 0;

        while (i < count.length()){
            char c = count.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }
            i++;
        }
    }
}
