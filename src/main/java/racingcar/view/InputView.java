package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.TryCount;
import racingcar.utils.StringUtils;

import java.util.List;

public class InputView {
    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        return StringUtils.splitCarNames(carNamesInput);
    }

    public static TryCount inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        System.out.println("\n");

        return new TryCount(Console.readLine());
    }
}
