package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class TextInterface {
    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askRacingcarRound() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void startRound() {
        System.out.println("실행 결과");
    }

    public void printResult(List<String> winnerCars) {
        String winnerResult = String.join(", ", winnerCars);
        String result = String.format("최종 우승자 : %s", winnerResult);
        System.out.println(result);
    }
}
