package racingcar.manager;

import java.util.List;
import racingcar.model.Car;
import racingcar.utils.Validator;
import racingcar.view.GameView;

public class GameManager {
    GameView gameView;
    public GameManager(){
        this.gameView = new GameView();
    }
    private List<Car> getCars(){
        String carNames = gameView.readCarNames();
        Validator.validateCarNames(carNames);
        return null;
    }
    public void start(){
        List<Car> cars = getCars();
    }
}
