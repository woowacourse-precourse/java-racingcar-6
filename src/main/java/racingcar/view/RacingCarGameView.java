package racingcar.view;

import java.util.List;

public class RacingCarGameView {
    public void enterCarNames() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.newLine();
    }

    public void enterTotalMoveCount() {
        System.out.print("시도할 회수는 몇회인가요?");
        this.newLine();
    }

    public void printResultText() {
        this.newLine();
        System.out.print("실행 결과");
        this.newLine();
    }

    public void printResult(List<String> results) {
        for(String result: results) {
            System.out.print(result);
            this.newLine();
        }
        this.newLine();
    }

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

    public void newLine() {
        System.out.println();
    }
}
