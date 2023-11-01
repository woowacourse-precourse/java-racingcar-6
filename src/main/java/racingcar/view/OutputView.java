package racingcar.view;

import java.util.List;
import racingcar.domain.dto.GameResult;

public class OutputView {
    public void outputResultString() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void outputGameResult(List<GameResult> gameResults) {
        gameResults
                .forEach(gameResult -> {
                    System.out.println(gameResult.getCarName() + " : " + "-".repeat(gameResult.getCarDistances()));
                });
        System.out.println();
    }

}
