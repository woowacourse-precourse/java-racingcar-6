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
        List<Car> participantCars = setupParticipantCars();

        // 시도 횟수 설정
        int rounds = setupRounds();

        // 게임 실행
        Game game = startGame(participantCars, rounds);

        // 결과 표시
        gameView.displayFinalWinner(game.getWinnerNames());
    }

    private List<Car> setupParticipantCars() {
        gameView.displayStartGame();
        String input = Console.readLine();
        CarValidator.validateNameUsingCommas(input);
        return gameService.setupParticipantCars(splitInputIntoList(input));
    }

    private static List<String> splitInputIntoList(String input) {
        return List.of(input.split(","));
    }

    private int setupRounds() {
        gameView.displayAskRounds();
        return gameService.setupRounds(Console.readLine());
    }

    private Game startGame(List<Car> participantCars, int rounds) {
        Game game = gameService.createGame(participantCars);

        gameView.displayResultMessage();
        for (int i = 0; i < rounds; i++) {
            gameService.controlCar(game);
            gameView.displayCurrentCarPosition(game.getCurrentParticipantCarPosition());
        }

        return game;
    }
}