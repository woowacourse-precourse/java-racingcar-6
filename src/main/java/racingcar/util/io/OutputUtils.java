package racingcar.util.io;

public class OutputUtils {
    private static final String CAR_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public static void printCarInputMessage() {
        System.out.println(CAR_INPUT_MESSAGE);
    }
}
