package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

public class ConsoleView {
    public static final String START_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)";
    public static final String TRY_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    public static final String RESULT_OUTPUT_MESSAGE = "실행 결과";
    public static final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";

    public void printStartMessage() {
        System.out.println(START_INPUT_MESSAGE);
    }

    public void printTryCountMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }

    public String readInput() {
        return Console.readLine();
    }

    public void printResultMessage() {
        System.out.println(RESULT_OUTPUT_MESSAGE);
    }

    public void printCurrentState(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.print(WINNER_OUTPUT_MESSAGE);
        if (!winners.isEmpty()) {
            String winnerMessage = String.join(", ", winners);
            System.out.print(winnerMessage);
        }
        System.out.println();
    }
}
