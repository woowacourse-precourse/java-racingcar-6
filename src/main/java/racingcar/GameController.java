package racingcar;

public class GameController implements Runnable {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameService gameService;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        gameService = new GameService();
    }

    @Override
    public void run() {
        String carName = inputView.scanCarName();
        RacingCars racingCars = gameService.generateRacingCarName(carName);

        String roundNumber = inputView.scanGameRound();
        GameRound gameRound = gameService.generateGameRound(roundNumber);

        GameResult gameResult = gameService.race(racingCars, gameRound, new RandomForwardMethod());
        outputView.printResult(gameResult);
    }
}
