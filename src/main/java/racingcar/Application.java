package racingcar;

import java.util.Arrays;
import java.util.List;

public class Application {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_TITLE_MESSAGE = "\n" + "실행 결과";
    public static void main(String[] args) {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carNameInput = camp.nextstep.edu.missionutils.Console.readLine();
        List<String> carNames = Arrays.stream(carNameInput.split(",")).toList();

        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        String tryCount = camp.nextstep.edu.missionutils.Console.readLine();

        System.out.println(RESULT_TITLE_MESSAGE);
    }
}
