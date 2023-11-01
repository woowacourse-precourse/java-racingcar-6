package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Output {

    private static final String INSTRUCTION_OF_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_EXECUTION_COUNT = "시도할 회수는 몇회인가요?";
    private static final String INSTRUCTION_OF_RESULT = "실행 결과";
    private static final String INSTRUCTION_OF_WINNER = "최종 우승자 : ";
    private static final String TRACE = "-";
    private static final String BLANK = " ";
    private static final String COMMA = ",";
    private static final String COLON = ":";

    public static void printInputCarNameInstruction() {
        System.out.println(INSTRUCTION_OF_INPUT_CAR_NAME);
    }

    public static void printExecutionCountQuestion() {
        System.out.println(ASK_EXECUTION_COUNT);
    }

    public static void printIntroductionOfResult() {
        System.out.println(INSTRUCTION_OF_RESULT);
    }

    public static void printResultOfEachExecution(List<Car> carList) {

        for (Car car : carList) {
            String driveTrace = "";
            for (int i = 0; i < car.getLocation(); i++) {
                driveTrace += TRACE;
            }
            System.out.printf(car.getName() + BLANK + COLON + BLANK + driveTrace);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print(INSTRUCTION_OF_WINNER);
        for (int i = 0; i < winners.size(); i++) {
            // 마지막 요소인 경우 콤마(,)생략
            if (i == winners.size() - 1) {
                System.out.print(winners.get(i).getName());
            } else {
                System.out.print(winners.get(i).getName() + COMMA + BLANK);
            }
        }
    }
}
