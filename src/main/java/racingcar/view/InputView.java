package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> enterCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String names = Console.readLine();
            return Arrays.stream(names.split(","))
                    .map(String::trim)
                    .toList();
        } finally {
            Console.close();
        }
    }

    public static int enterMovesNumber() {
        System.out.println("시도할 횟수는 몇회인가요?");
        try {
            String input = Console.readLine()
                    .trim();
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        } finally {
            Console.close();
        }
    }
}
