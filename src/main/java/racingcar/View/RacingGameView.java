package racingcar.View;
import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.Car;

import java.util.Arrays;
import java.util.List;

public class RacingGameView {
    public static final String CARNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ATTEMPT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String OUTPUT_MESSAGE = "\n실행 결과";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";

    public List<String> requestCarNames() {
        System.out.println(CARNAME_MESSAGE);
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public int requestRounds() {
        System.out.println(ATTEMPT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    public void printRoundResult(List<Car> cars, int round) {
        if (round == 0) {
            System.out.println(OUTPUT_MESSAGE);
        }
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(", ", winners));
    }
}
