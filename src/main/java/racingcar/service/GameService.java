package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.Output;

public class GameService {
    public static final int CHECK_FORWARD_NUMBER = 4;
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 0;

    private final Output output = new Output();

    public Game playAllGame(Game game) {
        for (int round = 1; round <= game.getRoundNumber(); round++) {
            playOneGame(game);
            output.printScore(game.getcarList());
        }

        return game;
    }

    public List<String> getWinner(Game game) {
        List<Car> cars = game.getcarList();
        int maxPosition = getMaxPosition(cars);
        return getMaxPositionCars(cars, maxPosition);
    }

    public void playOneGame(Game game) {
        moveForwardOfGame(game);
    }

    private void moveForwardOfGame(Game game) {
        for (Car car : game.getcarList()) {
            moveForwardByRandomNumber(car);
        }
    }

    private void moveForwardByRandomNumber(Car car) {
        if (generateRandomNumber() >= CHECK_FORWARD_NUMBER) {
            car.moveForward();
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }


    private int getMaxPosition(List<Car> carList) {
        int max = Integer.MIN_VALUE;
        for (Car car : carList) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }
        return max;
    }


    private List<String> getMaxPositionCars(List<Car> carList, int maxPosition) {
        List<String> carNames = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                carNames.add(car.getName());
            }
        }
        return carNames;
    }

}
