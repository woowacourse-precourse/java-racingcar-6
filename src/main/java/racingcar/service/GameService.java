package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameModel;

public class GameService {

    private GameModel gameModel;

    public void initGame(String[] carsName, int numberGames) {
        List<Car> inputCars = new ArrayList<>();
        for (String carName : carsName) {
            inputCars.add(new Car(carName));
        }
        Cars cars = new Cars(inputCars);
        this.gameModel = new GameModel(cars, numberGames);
    }


}
