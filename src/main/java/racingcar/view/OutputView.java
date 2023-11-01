package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatusDto;

public class OutputView {
    private static final String MOVE_EXPRESS = "-";
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT = "\n실행 결과";

    private OutputView() {
    }

    public static void printResult(List<CarStatusDto> carStatuses) {
        StringBuilder result = new StringBuilder();
        for (CarStatusDto carStatus : carStatuses) {
            String movement = MOVE_EXPRESS.repeat(carStatus.position());
            result.append(String.format("%s : %s\n", carStatus.name(), movement));
        }
        System.out.println(result);
    }

    public static void printWinner(String winner) {
        System.out.printf("최종 우승자 : %s", winner);
    }

    public static void printCarNameInputMessage() {
        System.out.println(INPUT_CAR_NAME);
    }

    public static void printTryCountInputMessage() {
        System.out.println(INPUT_TRY_COUNT);
    }

    public static void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }
}
