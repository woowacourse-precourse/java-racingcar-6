package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RaceInfoInput {
    public static String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input.split(",");
    }

    public static String inputNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
