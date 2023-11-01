package racingcar.controller;

import racingcar.domain.Game;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class PlayRacingGame {

    private final GameService gameService = new GameService();
    private final Parser parser = new Parser();
    private final Validator validator = new Validator();
    private final CarService carService = new CarService();

    private final InputView inputView = new InputView();


    public void racingGame(){
        carService.saveCars(getCarNames());
        playGame(createNewGame());
    }

    private Game createNewGame() {
        Game game = new Game(carService.getCarList(), getTrialNumber());
        gameService.saveGame(game);
        return game;
    }


    private void playGame(Game game){
        OutputView.beforePrintResult();
        while(!gameService.isGameEnd(game)){
            gameService.playOneGame(game);
            OutputView.printScore(game.getCars());
        }
        OutputView.printWinners(gameService.getWinner(game));
    }

    //축약 가능
    private int getTrialNumber(){
        String userInput = inputView.inputTrialNumber();
        validator.isValidTrialNumber(userInput);
        int trialNumber = parser.parseTrialNumber(userInput);
        return trialNumber;
    }

    private List<String> getCarNames(){
        String userInput = inputView.inputCarName();
        List<String> carNames = validator.isValidCarName(userInput);
        return carNames;
    }

}
