package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Round;

public class InputView {

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    public static Round inputRoundNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return Round.from(input);
    }
}
