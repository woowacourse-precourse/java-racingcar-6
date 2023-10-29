package racingcar.view;

import java.util.List;
import racingcar.domain.RacingGame;

public class OutputView {
    public void printNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printTryMessage() {
        System.out.println("실행 결과");
    }

    public void printTryResult(RacingGame game) {
        List<String> winnerNames = game.getWinnerNames();
        for (int i = 0; i < RacingGame.carCount; i++) {
            System.out.print(winnerNames.get(i) + " : ");
            System.out.println("-".repeat(game.getCarMove(i)));
        }
        System.out.println();
    }

    public void printWinnerMessage() {
        System.out.print("최종 우승자 : ");
    }

    public void printWinnerNames(RacingGame game) {
        List<String> winners = game.getWinnerNames();
        System.out.println(String.join(", ", winners));
    }
}
