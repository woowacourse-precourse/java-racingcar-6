package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = splitCarNames(Console.readLine());
    }

    private static List<String> splitCarNames(String input) {
        String[] carNamesArray = input.split(",");
        return List.of(carNamesArray);
    }
}
