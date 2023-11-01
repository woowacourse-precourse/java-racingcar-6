package racingcar.module.application;

import java.util.ArrayList;
import java.util.List;
import racingcar.module.dao.CarRepository;
import racingcar.module.dao.GameRepository;
import racingcar.module.domain.Car;
import racingcar.module.domain.Game;

public class GameService {

    private static final GameRepository gameRepository = GameRepository.getInstance();
    private static final CarRepository carRepository = CarRepository.getInstance();

    private static final GameService instance = new GameService();

    private GameService() {
    }

    public static GameService getInstance() {
        return instance;
    }

    public void setGame(List<String> names, int trial) {
        Game game = setTrial(trial);
        List<Car> cars = setName(game.getId(), names);
    }

    private Game setTrial(int trial) {
        Game game = Game.from(trial);
        Game savedGame = gameRepository.save(game);
        return savedGame;
    }

    private List<Car> setName(Long gameId, List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            Car car = Car.from(gameId, name);
            Car savedCar = carRepository.save(car);
            cars.add(savedCar);
        }
        return cars;
    }
}
