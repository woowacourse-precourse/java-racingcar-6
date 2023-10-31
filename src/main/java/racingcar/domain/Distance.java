package racingcar.domain;

public class Distance {

    private final int value;

    public Distance(String value) {
        this.value = numberCheck(value);
    }

    private int numberCheck(String value) {
        if (value.matches("-?\\d+")) {
            return Integer.parseInt(value);
        }
        throw new IllegalArgumentException("[ERROR] 정수만 입력할 수 있습니다.");
    }
}
