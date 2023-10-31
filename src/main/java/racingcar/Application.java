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
        validateCarNames(carNamesArray);
        return List.of(carNamesArray);
    }

    private static void validateCarNames(String[] carNamesArray) {
        for (String name : carNamesArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
