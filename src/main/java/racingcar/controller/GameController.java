package racingcar.controller;

import java.util.List;
import racingcar.service.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private Game game = new Game();

    public void setUp(){
        List<String> carNames = InputView.inputCarNames();
        game.setUp(carNames);
    }

    public void attempt(){
        Integer numberOfAttempt = InputView.inputNumberOfAttempt();

        OutputView.printOutputMessage();
        for(int i = 0; i<numberOfAttempt; i++){
            game.moveForwardAttemptCars();
            OutputView.printCars(game.getCars());
        }
    }

    public void end(){
        OutputView.printFinalists(game.getFinalists());
    }

}
