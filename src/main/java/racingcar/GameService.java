package racingcar;

public class GameService {
    private final User playUser = new User();
    private final Game game = new Game();

    public void initializeGameParameters() {
        InputView.inputCarName();
        playUser.splitCarNameAndVerify();
        InputView.inputPlayNum();
        playUser.parseIntPlayCountFromString();
    }

    public void startGame() {
        PrintView.printExecuteResultString();
        for (int i = 0; i < playUser.getPlayCount(); i++) {
            game.setForwordOrStay(playUser);
            game.printProgress(playUser);
        }
    }
    
    public void compareAndPrintWinner() {
        game.determineRaceWinner(playUser);
    }
}
