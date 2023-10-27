package racingcar.view;

import racingcar.dto.RacingResult;
import racingcar.dto.Winners;

import java.util.List;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printRacingResult(List<RacingResult> results) {
        System.out.println("실행 결과");
        results.forEach(result -> {
            String name = result.carName();
            String position = "-".repeat(result.position());
            System.out.println(name + " : " + position);
        });
    }

    public void printWinner(Winners winners) {
        String winnerNames = String.join(", ", winners.names());
        System.out.println("최종 우승자 : " + winnerNames);
    }

}
