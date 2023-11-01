package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    public static List<String> getCarNames() {
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(Console.readLine().split(",")).toList();
    }

    public static String getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}

