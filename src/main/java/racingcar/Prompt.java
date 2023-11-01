package racingcar;

import static racingcar.Properties.LINE_SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public enum Prompt {
    RACING_CAR_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ROUND_INPUT_MESSAGE("시도할 회수는 몇회인가요?"),
    RESULT_MESSAGE(LINE_SEPARATOR + "실행 결과"),
    WINNER_MESSAGE(LINE_SEPARATOR + "최종 우승자 : ");

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public static void println(String delim, List<String> content) {
        System.out.println(String.join(delim, content));
    }

    public static void print(String delim, List<String> content) {
        System.out.print(String.join(delim, content));
    }

    public void println() {
        System.out.println(message);
    }

    public void print() {
        System.out.print(message);
    }

    public String read() {
        System.out.println(message);
        return Console.readLine();
    }
}
