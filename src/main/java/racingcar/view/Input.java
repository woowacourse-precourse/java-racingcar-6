package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import racingcar.Validation;

public class Input {
    static Validation validation = new Validation();

    public static List<String> readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();
        return validation.formatCarNames(input);
    }

    public static Integer readRoundCount() {
        System.out.println("시도할 회수는 몇 회인가요?");
        String input = readLine();
        return validation.formatRoundCount(input);
    }
}
