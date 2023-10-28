package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class RacingCarInputManager {

    private final RacingCarOutputManager outputManager;

    public RacingCarInputManager(RacingCarOutputManager outputManager) {
        this.outputManager = outputManager;
    }

    private static final String CAR_NAME_SEPARATOR = ",";

    public List<String> readCarNames() {
        outputManager.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(readLine().split(CAR_NAME_SEPARATOR))
                .toList();
    }

    public String readTryToMoveTurnCount() {
        outputManager.println("시도할 회수는 몇회인가요?");
        return readLine();
    }

    // `디미터의 법칙`에 따라 분리
    // 개발자가 Console을 알아야할 필요없이 readLine만 알아도 됨.
    private String readLine() {
        return Console.readLine();
    }


}
