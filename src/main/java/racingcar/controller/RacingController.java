package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Game;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;
import java.util.List;


public class RacingController {

    private final GameService gameService = new GameService();
    private final CarService carService = new CarService();
    private Game game;

    public void run() {
        initGame();
        gameStart();
        getWinner();
    }

    public void initGame() {
        initInputCarAndRound();
        initCar();
        initBuilder();
    }

    public void initInputCarAndRound() {
        String carName = inputCarName();
        int carCount = carService.initInputCarName(carName);

        String inputRound = inputGameRound();
        int round = gameService.initGameRound(inputRound);

        game = gameService.setGame(carCount,round);
    }

    public String inputCarName() {
        System.out.println(InputMessage.INPUT_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public String inputGameRound() {
        System.out.println(InputMessage.INPUT_GAME_ROUND_MESSAGE);
        return Console.readLine();
    }

    public void initCar() {
        this.carService.initCar();
    }

    public void initBuilder() {
        this.carService.initBuilder();
    }

    public void gameStart() {

        int roundCount = game.getRoundCount();
        int carsCount = game.getCarsCount();

        for (int roundIndex = 0; roundIndex < roundCount; roundIndex++) {
            carService.updateCarPosition();
            String[] carPositions = carService.getGameStatus();
           OutputMessage.printGameStatusMessage(carPositions, carsCount);
        }
    }

    public void getWinner() {
        List<String> winner = carService.getWinner();
        System.out.print(OutputMessage.OUTPUT_WINNER_MESSAGE);
        OutputMessage.printWinnerMessage(winner);
    }


}
