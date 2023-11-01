package view;

import model.dto.MoveResult;
import java.util.List;

public class OutputView {

    private static final String MOVING_CHARACTER = "-";
    private static final String CARS_JOINER = ", ";

    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void informBeforeShowMove() {
        System.out.println("실행 결과");
    }

    public void informResult(final List<MoveResult> moveResults) {
        moveResults.forEach(result -> {
            System.out.printf("%s : %s\n", result.carName(),
                MOVING_CHARACTER.repeat(result.moveCount()));
        });
        System.out.println();
    }

    public void showWinners(final List<String> winners) {
        System.out.printf("최종 우승자 : %s", String.join(CARS_JOINER, winners));
    }
}
