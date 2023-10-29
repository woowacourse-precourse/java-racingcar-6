package racingcar;

public class GameService {
    private final User playUser = new User();
    private final Game game = new Game();
    PrintView printView = new PrintView();

    public void input() {
        playUser.inputCarName();
        playUser.setPlayNum();
    }

    public void startGame() {
        game.setForwordOrStay(playUser);
    }

    public void printWinner() {

    }
}
