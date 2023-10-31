package racingcar.domain;

public class Output {

    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    public void printMoveResult(Cars cars) {
        String result = cars.getMoveResult();
        System.out.println(result);
    }

    public void printWinner(Cars cars) {
        Winners winners = cars.findWinner();
        String winnerList = winners.makeWinnerList();
        System.out.print(WINNER_MESSAGE + winnerList);
    }

    public void printInputCarNameMessage() {
        System.out.println(CAR_NAME_MESSAGE);
    }

    public void printInputGameCountMessage() {
        System.out.println(GAME_COUNT_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println(GAME_RESULT_MESSAGE);
    }
}
