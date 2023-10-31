package racingcar.service;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.constant.GameCondition;
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
