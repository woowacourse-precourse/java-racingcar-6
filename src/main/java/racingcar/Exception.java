package racingcar;

public class Exception {
    public void validateInputNotStartWithComma(String input) {
        if (input.startsWith(","))
            throw new IllegalArgumentException("입력값은 쉼표로 시작할 수 없습니다.");
    }

    public void validateInputContainsConsecutiveCommas(String input) {
        if (input.contains(",,"))
            throw new IllegalArgumentException("쉼표는 연속으로 들어갈 수 없습니다.");
    }

    public void validateNumberOfCarName(String[] splitCarName) {
        for (String carName : splitCarName) {
            if (carName.length() > 5)
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
