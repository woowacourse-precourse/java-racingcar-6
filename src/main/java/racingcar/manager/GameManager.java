package racingcar.manager;

import java.util.List;
import racingcar.model.Car;
import racingcar.utils.Validator;
import racingcar.view.GameView;

public class GameManager {
    private GameView gameView;
    public GameManager(){
        this.gameView = new GameView();
    }
    private List<Car> getCars(){
        String carNames = gameView.readCarNames();
        Validator.validateCarNames(carNames);
        return null;
    }

    private int getNumberOfMoves(){
        String numberOfMoves = gameView.readNumberOfMoves();
        return Integer.parseInt(numberOfMoves);
    }

    public void start(){
        List<Car> cars = getCars();
        int numberOfMoves = getNumberOfMoves();
    }
}
