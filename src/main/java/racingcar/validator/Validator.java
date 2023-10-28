package racingcar.validator;

public class Validator {
    public void carNameStringLength(String carName) {
        if (carName.length() <= 5) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 이름 길이 5초과");
    }

    public void isNull(String carName) {
        if (carName == "") {
            throw new IllegalArgumentException("[ERROR] 이름이 존재하지 않습니다.");
        }
    }
}
