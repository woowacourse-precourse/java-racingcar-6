package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {

    private final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final String INPUT_TRY_TIMES = "시도할 회수는 몇회인가요?";
    public final String HASH = ",";

    public List<String> getInputRacingCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        return List.of(Console.readLine().split(HASH));
    }

    public Integer getInputTryTimes() {
        System.out.println(INPUT_TRY_TIMES);
        return Integer.valueOf(Console.readLine());
    }
}
