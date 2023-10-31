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
}
