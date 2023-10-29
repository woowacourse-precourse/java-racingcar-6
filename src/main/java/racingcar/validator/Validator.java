package racingcar.validator;

public class Validator {
    public static void carNameStringLength(String carName) {
        if (carName.length() <= 5) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 이름 길이 5초과");
    }

    public static void isNull(String carName) {
        if (carName == "") {
            throw new IllegalArgumentException("[ERROR] 입력이 존재하지 않습니다.");
        }
    }

    //콤마 개수랑 이름 개수가 안 맞으면 throw
    public static void carNamesComma(String carNames) {
        int commaCount = (int) carNames.chars()
                .filter(c -> c == ',')
                .count();
        int nameCount = carNames.split(",").length;
        if (commaCount + 1 != nameCount) {
            throw new IllegalArgumentException("[ERROR] 콤마의 사용이 부적절합니다.");
        }
    }
}
