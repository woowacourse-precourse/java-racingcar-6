package racingcar;

public class GameService {
    private final User playUser = new User();
    private final Game game = new Game();
    private final PrintView printView = new PrintView();

    public void input() {
        playUser.inputCarName();
        playUser.setPlayNum();

    }

    public void startGame() {
        printView.printExecuteResultString();
        for (int i = 0; i < playUser.getPlayNum(); i++) {
            game.setForwordOrStay(playUser);
            game.printProgress(playUser);
        }
    }
    
    public void printPutWinner() {
        game.compareWinner(playUser);
    }
}
