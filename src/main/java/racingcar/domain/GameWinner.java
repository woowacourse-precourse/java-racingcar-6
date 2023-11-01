package racingcar.domain;

import java.util.List;

/*
 * 우승자의 정보를 담당
 * */

public class GameWinner {
    
    private final int FROM_BEGIN = 0;
    private final int NOT_USED_INDEX = 2;
    private final List<Car> cars;

    private GameWinner(List<Car> gameWinners) {
        this.cars = gameWinners;
    }

    public static GameWinner from(List<Car> winningCars) {
        return new GameWinner(winningCars);
    }

    public String getNames() {
        StringBuilder names = new StringBuilder();
        for (Car car : cars) {
            names.append(car.getName()).append(", ");
        }
        return names.substring(FROM_BEGIN, names.length() - NOT_USED_INDEX);
    }
}
