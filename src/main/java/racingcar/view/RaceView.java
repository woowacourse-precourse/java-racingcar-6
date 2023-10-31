package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class RaceView {
    private static final String INPUT_CARNAMES_SENTENSE = "자동차 이름을 입력해주세요(이름은 쉼표(,)로 구분해주세요.";
    private static final String INPUT_MOVE_COUNT_SENTENCE = "몇번 시도하시겠습니까?";
    private static final String EXECUTION_RESULT_SENTENCE = " 실행 결과";
    private static final String WINNER_SENTENCE = "최종 우승은 :";
    public void printInputCarName() {
        System.out.println(INPUT_CARNAMES_SENTENSE);
    }
    public void printInputTrialCount() {
        System.out.println(INPUT_MOVE_COUNT_SENTENCE);
    }
    public void printExecutionResult() {
        System.out.println(EXECUTION_RESULT_SENTENCE);
    }
    public void printProgress(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + ":" + car.viewProgress());
        }
        System.out.println();
    }
    public void printFinalWinner(List<String> winners) {
        System.out.println(WINNER_SENTENCE);
        String winner = String.join(", ", winners);
        System.out.println("winner = " + winner);
    }
}
