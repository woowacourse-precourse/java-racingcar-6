package racingcar.domain;

public class Output {

    public void printMoveResult(Cars cars) {
        String result = cars.getMoveResult();
        System.out.println(result);
    }

    public void printWinner(Cars cars) {
        Winners winners = cars.findWinner();
        String winnerList = winners.makeWinnerList();
        System.out.print("최종 우승자 : " + winnerList);
    }

    public void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(.) 기준으로 구분)");
    }

    public void printInputGameCountMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
