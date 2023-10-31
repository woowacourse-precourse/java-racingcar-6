package racingcar.view;

public class OutputView {
    public final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    public final String START_STEP_MESSAGE = "\n실행 결과";

    public void display(String message) {
        System.out.println(message);
    }

    public void displayWinner(String winnerMessage) {
        System.out.println("최종 우승자 : " + winnerMessage);
    }
}
