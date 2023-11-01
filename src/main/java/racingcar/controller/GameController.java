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

    public void move(){
        Integer numberOfTrial = InputView.inputNumberOfTrial();

        OutputView.printOutputMessage();
        for(int i = 0; i<numberOfTrial; i++){
            game.moveCars();
            OutputView.printCars(game.getCars());
        }
    }

    public void end(){
        OutputView.printFinalistsName(game.getFinalistsName());
    }

}
