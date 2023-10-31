package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Game;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.view.InputMessage;
import racingcar.view.OutputMessage;

import java.util.ArrayList;
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
        String inputRound = inputGameRound();

        int carCount = carService.initInputCarName(carName);
        int round = gameService.initGameRound(inputRound);

        game = gameService.setGame(carCount, round);
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
            String GAME_STATUS_MESSAGE = OutputMessage.printGameStatusMessage(carPositions, carsCount);
            System.out.print(GAME_STATUS_MESSAGE);
        }
    }

    public void getWinner() {
        List<String> winner = new ArrayList<>();
        winner = carService.getWinner(winner);
        System.out.print(OutputMessage.OUTPUT_WINNER_MESSAGE);
        String WINNER_MESSAGE = OutputMessage.printWinnerMessage(winner);
        System.out.println(WINNER_MESSAGE);
    }
}
