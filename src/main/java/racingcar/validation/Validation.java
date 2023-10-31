package racingcar.validation;

public class Validation {

    private static boolean isConsecutiveComma(String names){
        int i = 0;
        boolean prevComma = false;

        while (i < names.length()){
            if (names.charAt(i) == ','){
                if (prevComma) return true;
                prevComma = true;
                i++;
                continue;
            }
            prevComma = false;
            i++;
        }
        return false;
    }

    private static boolean isLengthen(String names){
        String[] nameList = names.split(",");
        int i = 0;

        while (i < nameList.length){
            if (nameList[i].length() > 5) return true;
            i++;
        }
        return false;
    }

    private static boolean isNumberString(String count){
        int i = 0;

        while (i < count.length()){
            char c = count.charAt(i);
            if (c < '0' || c > '9') return false;
            i++;
        }
        return true;
    }

    public static void validNames(String names){
        if (isConsecutiveComma(names) || isLengthen(names)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static void validCount(String count){
        if (!isNumberString(count)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
