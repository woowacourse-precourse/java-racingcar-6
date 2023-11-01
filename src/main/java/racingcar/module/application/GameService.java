package racingcar.module.application;

import static racingcar.global.constant.Game.END_RANGE;
import static racingcar.global.constant.Game.FORWARD_STANDARD;
import static racingcar.global.constant.Game.START_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.module.dao.CarRepository;
import racingcar.module.dao.GameRepository;
import racingcar.module.domain.Car;
import racingcar.module.domain.Game;
import racingcar.module.view.Output;

public class GameService {

    private static final GameRepository gameRepository = GameRepository.getInstance();
    private static final CarRepository carRepository = CarRepository.getInstance();

    private static final GameService instance = new GameService();

    private GameService() {
    }

    public static GameService getInstance() {
        return instance;
    }

    public Long setGame(List<String> names, int trial) {
        Game game = setTrial(trial);
        setName(game.getId(), names);
        return game.getId();
    }

    public void playGame(Long gameId) {
        Game game = gameRepository.findById(gameId);
        List<Car> carList = carRepository.findByGame(gameId);

        Output.printResultMessage();

        while (game.play() < game.getTrial()) {
            play(carList);
        }
        Output.printWinners(getWinners(gameId));
    }

    private void play(List<Car> carList) {
        for (Car car : carList) {
            if (moveForwardByRandomNumber()) {
                car.moveForward();
            }
            Output.printResult(car.getName(), car.getMoving());
        }
        Output.endPlay();
    }

    private boolean moveForwardByRandomNumber() {
        if (generateRandomNumber() >= FORWARD_STANDARD) {
            return true;
        }
        return false;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(START_RANGE, END_RANGE);
    }

    private List<String> getWinners(Long gameId) {
        List<Car> carList = carRepository.findByGame(gameId);

        int max = getMaxMoving(carList);
        List<String> winners = getMaxMovingCars(max, carList);
        return winners;
    }

    private int getMaxMoving(List<Car> carList) {
        int max = Integer.MIN_VALUE;

        for (Car car : carList) {
            if (max < car.getMoving()) {
                max = car.getMoving();
            }
        }
        return max;
    }

    private List<String> getMaxMovingCars(int max, List<Car> carList) {
        List<String> winnerNames = new ArrayList<>();

        for (Car car : carList) {
            if (max == car.getMoving()) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    private Game setTrial(int trial) {
        Game game = Game.from(trial);
        Game savedGame = gameRepository.save(game);
        return savedGame;
    }

    private void setName(Long gameId, List<String> names) {
        for (String name : names) {
            Car car = Car.from(gameId, name);
            carRepository.save(car);
        }
    }
}
