package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.RacingcarGame;
import racingcar.domain.dto.CarDTO;
import racingcar.domain.dto.InitDTO;
import racingcar.view.EndScreen;
import racingcar.view.InitScreen;
import racingcar.view.RoundScreen;

public class GameController {
    private final RacingcarGame game;
    public GameController(){
        InitDTO initDTO = InitScreen.init();
        this.game = new RacingcarGame(initDTO);
    }
    public void execute(){
        playGame();
        end();
    }

    private void playGame(){
        RoundScreen.startMessage();
        while (game.isEnd()) {
           playRound();
        }

    }
    private void playRound(){
        List<CarDTO> cars = game.play();
        RoundScreen.printPositions(cars);
    }

    private void end(){
        List<CarDTO> winners = game.end();
        EndScreen.printWinner(winners);
    }
}
