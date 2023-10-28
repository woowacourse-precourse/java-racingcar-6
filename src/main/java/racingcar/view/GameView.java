package racingcar.view;

public class GameView {
    public void displayUserInputCarNamePrompt() {
        displayMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }
}
