package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import racingcar.core.Racing;
import racingcar.util.StringUtils;

public class Application {
    public static void main(String[] args) {
        final Racing racing = new Racing();

        racing.registerCarsByName(inputCarNames());
        racing.registerRaceCount(inputRaceCount());
        racing.doRace();
        racing.printWinner();
    }

    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return StringUtils.splitByComma(Console.readLine());
    }

    private static int inputRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return StringUtils.parseInt(Console.readLine());
    }
}
