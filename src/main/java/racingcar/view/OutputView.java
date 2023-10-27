package racingcar.view;

import java.util.List;
import racingcar.dto.CarStatusDto;

public class OutputView {
    private static final String MOVE_EXPRESS = "-";

    private OutputView() {
    }

    public static void printResult(List<CarStatusDto> carStatuses) {
        for (CarStatusDto carStatus : carStatuses) {
            String movement = MOVE_EXPRESS.repeat(carStatus.position());
            System.out.printf("%s : %s \n", carStatus.name(), movement);
        }
        System.out.println();
    }

    public static void printWinner(String winner) {
        System.out.printf("최종 우승자 : %s", winner);
    }

    public static void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printTryCountInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printExecutionResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
