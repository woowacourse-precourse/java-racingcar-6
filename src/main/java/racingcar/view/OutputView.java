package racingcar.view;

public class OutputView {

    private static final String GAME_RESULT_TITLE = "실행 결과";
    private static final String GAME_WINNER_FORMAT = "최종 우승자 : %s\n";

    public void printResultTitle(){
        System.out.println(GAME_RESULT_TITLE);
    }

    public void printResult(String result){
        System.out.println(result);
        System.out.println();
    }

    public void printWinner(String winner){
        System.out.printf(GAME_WINNER_FORMAT, winner);
    }


}
