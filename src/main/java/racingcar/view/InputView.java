package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.Validator;

public class InputView {
    public static List<String> readRacingCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCarName = Console.readLine();
        return Arrays.stream(racingCarName.split(","))
                .map(String::trim)
                .toList();
    }

    public static long readTryCount() {
        System.out.println("시도활 회수는 몇회인가요?");
        String tryCount = Console.readLine().trim();
        Validator.validateIsNumeric(tryCount);

        return Long.parseLong(tryCount);
    }
}
