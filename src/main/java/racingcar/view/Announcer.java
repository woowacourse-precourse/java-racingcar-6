package racingcar.view;

import java.util.List;
import racingcar.Car;

public class Announcer {
    private final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private final String RESULT_COMMENT = "실행 결과";

    public void announceToInputCarName() {
        print(INPUT_CAR_NAME);
    }

    public void announceToInputTryCount() {
        print(INPUT_TRY_COUNT);
    }

    public void announceResultComment() {
        print("");
        print(RESULT_COMMENT);
    }

    public void announceRoundHistory(List<Car> car) {
        for (Car c : car) {
            print(c.getName() + " : " + "-".repeat(c.getPosition()));
        }
        print("");
    }

    public void announceWinner(List<String> winnerList) {
        String winner = String.join(", ", winnerList);
        print("최종 우승자 : " + winner);
    }

    public void print(String message) {
        System.out.println(message);
    }
}
