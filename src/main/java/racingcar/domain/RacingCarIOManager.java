package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class RacingCarIOManager {

    private static final String CAR_NAME_SEPARATOR = ",";

    public List<String> readCarNames() {
        return Arrays.stream(readLine().split(CAR_NAME_SEPARATOR))
                .toList();
    }

    // `디미터의 법칙`에 따라 분리
    // 개발자가 Console을 알아야할 필요없이 readLine만 알아도 됨.
    private String readLine() {
        return Console.readLine();
    }
}
