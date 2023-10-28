package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingRepeat;

public class InputView {
    private static final String INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_REPEAT = "시도할 회수는 몇회인가요?";

    private InputView() {
        // 생성자 호출 방지
    }

    public static String[] inputNames() {
        System.out.println(INPUT_NAME);
        return inputNames(Console.readLine());
    }
    public static String[] inputNames(String input) {
        return input.split(",");
    }

    public static RacingRepeat inputRepeat() {
        System.out.println(INPUT_REPEAT);
        return inputRepeat(Console.readLine());
    }
    public static RacingRepeat inputRepeat(String input) {
        return new RacingRepeat(input);
    }
}
