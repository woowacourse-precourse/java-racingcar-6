package racingcar.view.core;

import java.util.function.Consumer;

public enum PrintMessage {
    PRINT_GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    PRINT_TRY_COUNT("시도할 회수는 몇회인가요?"),

    PRINT_RACE_RESULT("\n실행 결과");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public void invoke(Consumer<String> consumer) {
        consumer.accept(message);
    }
}
