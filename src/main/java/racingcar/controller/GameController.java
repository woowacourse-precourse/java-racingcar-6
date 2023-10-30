package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.service.GameService;
import racingcar.validator.CarValidator;
import racingcar.view.GameView;

public class GameController {

    private final GameView gameView;
    private final GameService gameService;

    public GameController(GameView gameView, GameService gameService) {
        this.gameView = gameView;
        this.gameService = gameService;
    }

    public void playGame() {
        // 시작 및 참가 차량 설정
        gameView.displayStartGame();

        String input = Console.readLine();
        CarValidator.validateNameUsingCommas(input);
        List<String> carNameList = List.of(input.split(","));
        List<Car> participantCars = gameService.setupParticipantCars(carNameList);
        Game game = gameService.createGame(participantCars);

        // 시도횟수 설정
        gameView.displayAskRounds();
        int rounds = gameService.setupRounds(Console.readLine());

        // 게임 실행
        gameView.displayResultMessage();
        for (int i = 0; i < rounds; i++) {
            gameService.controlCar(game);
            gameView.displayCurrentCarPosition(game.getCurrentParticipantCarPosition());
        }
        gameView.displayFinalWinner(game.getWinnerNames());
    }
}