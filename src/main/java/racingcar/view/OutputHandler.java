package racingcar.view;

import java.util.List;
import racingcar.dto.RacingStatus;

public class OutputHandler {

    public static void printRequestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRequestNumberOfAttempt() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printAttemptResult(RacingStatus status) {
        for (String carName : status.getCarNames()) {
            System.out.println(carName + " : " + status.getCarPosition(carName));
        }
        System.out.println();
    }

    public static void printWinner(List<String> winner){
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
