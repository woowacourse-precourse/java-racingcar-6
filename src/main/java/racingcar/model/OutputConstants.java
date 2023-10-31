package racingcar.model;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum OutputConstants {
    PROMPT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    PROMPT_COUNT("시도할 회수는 몇회인가요?"),
    PREFIX("최종 우승자 : "),
    COLON(" : "),
    HYPHEN("-"),
    DELIMITER(","),
    DELIMITER_PLUS_SPACE(", "),
    INTEGER("\\d+");

    private final String value;


    OutputConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String repeat(int times) {
        return Stream.generate(() -> this.value)
                .limit(times)
                .collect(Collectors.joining());
    }

    @Override
    public String toString() {
        return this.value;
    }
}
