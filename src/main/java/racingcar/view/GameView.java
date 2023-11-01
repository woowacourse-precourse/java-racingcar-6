package racingcar.view;

public class GameView {

    public void displayStartGame() {
        System.out.println(GameMessages.START_GAME.getMessage());
    }

    public void displayAskRounds() {
        System.out.println(GameMessages.ASK_ROUNDS.getMessage());
    }

    public void displayResultMessage() {
        System.out.println(GameMessages.RESULT_MESSAGE.getMessage());
    }

    public void displayFinalWinner(String winner) {
        System.out.println(GameMessages.FINAL_WINNER.format(winner));
    }

    public void displayCurrentCarPosition(String currentParticipantCarPosition) {
        System.out.println(GameMessages.CURRENT_POSITION.format(currentParticipantCarPosition));
    }
}
