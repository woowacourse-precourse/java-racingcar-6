package racingcar.manager;

import camp.nextstep.edu.missionutils.Randoms;
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
        return Car.createCars(carNames);
    }

    private int getNumberOfMoves(){
        String numberOfMoves = gameView.readNumberOfMoves();
        Validator.validateNumberOfMoves(numberOfMoves);
        return Integer.parseInt(numberOfMoves);
    }

    private void moveCars(List<Car> cars){
        for(Car car : cars){
            if(Randoms.pickNumberInRange(0,9) >= 4) {
                car.move();
                continue;
            }
            car.pause();
        }
    }

    public void start(){
        List<Car> cars = getCars();
        int numberOfMoves = getNumberOfMoves();
        for(int i=0; i<numberOfMoves; i++){
            moveCars(cars);
        }
    }
}
