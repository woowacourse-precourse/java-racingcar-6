package racingcar.View;

public class OutputView {

    private static final String START_INTRO = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇회인가요?";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public void printStartIntro() {
        System.out.println(START_INTRO);
    }

    public void askForNumberOfAttempts() {
        System.out.println(ASK_NUMBER_OF_ATTEMPTS);
    }

    public void printFinalWinner() {
        System.out.println(FINAL_WINNER);
    }

}
