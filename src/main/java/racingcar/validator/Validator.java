package racingcar.validator;

public class Validator {
    public static void carNameStringLength(String carName) {
        if (carName.length() <= 5) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 이름 길이 5초과");
    }

    public static void isSpace(String input) {
        if (input == " ") {
            throw new IllegalArgumentException("[ERROR] 입력이 스페이스 입니다.");
        }
    }

    public static void isNull(String input) {
        if (input == "") {
            throw new IllegalArgumentException("[ERROR] 입력이 존재하지 않습니다.");
        }
    }

    //콤마 개수랑 이름 개수가 안 맞으면 throw
    public static void carNamesComma(String carNames) {
//        int commaCount = (int) carNames.chars()
//                .filter(c -> c == ',')
//                .count();
//        int nameCount = carNames.split(",").length;
//        System.out.println("콤마개수: " + commaCount + ", 이름개수: "+ nameCount);
//        if (commaCount + 1 != nameCount) {
//            throw new IllegalArgumentException("[ERROR] 콤마의 사용이 부적절합니다.");
//        }

        String regularExpForInput = "[^,]+,(?:[^,]+,)*[^,]+";
        if (!carNames.matches(regularExpForInput)) {
            throw new IllegalArgumentException("[ERROR] 자동자이름들 형식이 잘못 됐습니다.");
        }
    }


    public static void isNumber(String input) {
        String regularExpForInput = "\\d+";
        if (!input.matches(regularExpForInput)) {
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다.");
        }
    }

    public static void attemptNumberRange(String attemptNumberString) {
        int attemptNumber = Integer.parseInt(attemptNumberString);
        if (attemptNumber >= 1) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 입력시도는 한번 이상이어야 합니다.");
    }

}
