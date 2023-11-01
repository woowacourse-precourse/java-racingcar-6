package racingcar.view;

public class OutputView {

    public void displayGameResult() {
        System.out.println(GameMessage.RESULT.getMessage());
    }

    public void displayFinalWinner() {
        System.out.print(GameMessage.FINAL_WINNER.getMessage());
    }
}
