package racingcar.view;

public class OutputView {
    public final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public void displayGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }
}
