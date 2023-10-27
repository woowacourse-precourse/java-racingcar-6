package racingcar.view;

import racingcar.domain.Car;
import java.util.List;

public class RaceView {

    private static final String INPUT_CARNAME_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MOVE_TRIAL_COUNT_SENTENCE = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT_SENTENCE = "실행 결과";
    private static final String FINAL_WINNER_SENTENCE = "최종 우승자 : ";

    public void printInputCarname() {
        System.out.println(INPUT_CARNAME_SENTENCE);
    }

    public void printInputMoveTrialCount() {
        System.out.println(INPUT_MOVE_TRIAL_COUNT_SENTENCE);
    }

    public void printExecutionResult() {
        System.out.println(EXECUTION_RESULT_SENTENCE);
    }

    public void printProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.viewProgress());
        }
        System.out.println();
    }

    public void printFinalWinner(List<String> winners) {
        System.out.print(FINAL_WINNER_SENTENCE);
        String print = String.join(", ", winners);
        System.out.println(print);
    }
}
