package racingcar.service;


import java.util.List;
import racingcar.domain.Car;
import racingcar.view.GameConsoleIO;

public class GameService {
    private static List<Car> cars;
    private static GameConsoleIO gameConsoleIO;


    public GameService() {
        cars = new ArrayList<>();
        gameConsoleIO = new GameConsoleIO();
    }


    private void setCars() {
        cars = gameConsoleIO.getCarNames()
                .stream().map(Car::new).toList();
    }


    private int getMovingCount() {
        return gameConsoleIO.getMovingCount();
    }

}
