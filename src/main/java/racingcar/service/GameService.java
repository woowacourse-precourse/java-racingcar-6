package racingcar.service;


import java.util.List;
import racingcar.domain.Car;
import racingcar.view.GameConsoleIO;

public class GameService {
    private static List<Car> cars;
    private static GameConsoleIO gameConsoleIO;

    private static int movingCount;


    public GameService() {
        gameConsoleIO = new GameConsoleIO();
        setCars();
        setMoveCount();
    }


    private void setCars() {
        List<String> carNames = gameConsoleIO.getCarNames();
        carNames.forEach(name -> cars.add(new Car(name)));
    }

    private void setMoveCount() {
        movingCount = gameConsoleIO.getMovingCount();
    }


}
