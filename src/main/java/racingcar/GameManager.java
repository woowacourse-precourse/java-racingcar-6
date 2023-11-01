package racingcar;

public class GameManager {

    private Player player;
    private RacingCarGame racingCarGame;
    private OutputView outputView;

    public GameManager() {
        player = new Player();
        racingCarGame = new RacingCarGame();
        outputView = new OutputView();
    }

    public void start() {
        outputView.printNameMessage();
        String carName = player.inputCarName();

        outputView.printCountMessage();
        int movingCount = player.inputMovingCount();

        racingCarGame.splitCarName(carName);
        racingCarGame.saveMovingCount(movingCount);

        outputView.printResultMessage();

        while (true) {
            if (racingCarGame.isGameOver()) {
                outputView.printWinnerMessage();
                System.out.println(racingCarGame.getWinnerName());
                break;
            }
            outputView.printRacingCarGameResult(racingCarGame.getCarNameList(), racingCarGame.getCarMovingCountList());
        }

    }
}
