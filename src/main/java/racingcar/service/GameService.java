package racingcar.service;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
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


    public void playGame() {

        setCars();
        int movingCount = getMovingCount();

        gameConsoleIO.printExecuteResultMessage();

        IntStream.rangeClosed(1, movingCount).forEach(i -> {
            executeEachMovingCount();
            System.out.println();
        });

        gameConsoleIO.printWinners(getWinners());
    }


    private void executeEachMovingCount() {
        for (Car car : cars) {
            if (isForward()) {
                car.goForward();
            }
            gameConsoleIO.printCarLocationByCarName(car.getName(), car.getLocation());
        }
    }

    private boolean isForward() {
        int randomNum = Randoms.pickNumberInRange(
                GameCondition.MIN_RANDOM_NUM.getValue(),
                GameCondition.MAX_RANDOM_NUM.getValue()
        );

        return randomNum >= GameCondition.MOVING_FORWARD_CONDITION.getValue();
    }


    private List<String> getWinners() {
        int maxLocation = cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(NoSuchElementException::new);

        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .toList();
    }
}
