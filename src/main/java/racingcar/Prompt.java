package racingcar;

import camp.nextstep.edu.missionutils.Console;

public enum Prompt {
    RACING_CAR_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ROUND_INPUT_MESSAGE("시도할 회수는 몇회인가요?"),
    RESULT_MESSAGE("실행 결과"),
    WINNER_MESSAGE("최종 우승자 : ");

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public void println(String prefix, String suffix) {
        System.out.println(prefix + message + suffix);
    }

    public void print(String prefix, String suffix) {
        System.out.print(prefix + message + suffix);
    }

    public String read() {
        System.out.println(message);
        return Console.readLine();
    }
}
