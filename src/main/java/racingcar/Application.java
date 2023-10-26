package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void printInputCarNameMessage() {
        final String STRING_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        System.out.println(STRING_INPUT_CAR_NAME);
    }

    public static String readCarNames() {
        final String carNames = Console.readLine();
        Console.close();
        return carNames;
    }

    public static List<String> getCarNameListFromCarNames(final String carNames) {
        return List.of("");
    }
}
