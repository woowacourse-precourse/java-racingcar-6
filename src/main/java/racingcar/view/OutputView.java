package racingcar.view;

import java.util.List;
import racingcar.dto.CarResult;

public class OutputView {
    public void outputResultString() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void outputGameResult(List<CarResult> gameResults) {
        gameResults
                .forEach(gameResult -> {
                    System.out.println(gameResult.getCarName() + " : " + "-".repeat(gameResult.getCarDistances()));
                });
        System.out.println();
    }

    public void outputGameWinner(List<String> winnerCarNameList) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerCarNameList));
    }
}
