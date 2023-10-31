package racingcar;

public class OutputView {

    public static final String START_GAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ASK_NUMBER_OF_RACE = "시도할 회수는 몇회인가요?";
    public static final String SHOW_RESULT_OF_EACH_RACE = "\n실행 결과";
    public static final String SHOW_WINNER = "최종 우승자 : ";

    public OutputView() {
    }

    public void startGame() {
        System.out.println(START_GAME);
    }

    public void askNumberOfRace() {
        System.out.println(ASK_NUMBER_OF_RACE);
    }

    public void showResultOfEachRace() {
        System.out.println(SHOW_RESULT_OF_EACH_RACE);
    }

    public void showWinner() {
        System.out.print(SHOW_WINNER);
    }
}
