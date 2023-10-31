package racingcar.view;

import racingcar.domain.RacingBoard;

public class Output {
    public void questionCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public void questionAttemptNum() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void printExecutionStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printExecution(RacingBoard racingBoard) {
        System.out.println(racingBoard.viewExecution());
    }

    public void printWinner(RacingBoard racingBoard) {
        System.out.print("최종 우승자 : ");
        System.out.println(racingBoard.viewWinner());
    }
}