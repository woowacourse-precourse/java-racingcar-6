package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Game {
    private List<Car> carList;
    private int count;
    private int topDistance;

    private Game(){}

    public static Game createGame(List<Car> carList, int count){
        Game game = new Game();
        game.carList = carList;
        game.count = count;
        game.topDistance = 0;

        return game;
    }


    public void updateCarsMove() {
        for (Car car : carList) {
            car.moveForward();
        }
    }

    public void determineTopDistance() {
        this.topDistance = carList.stream()
                .mapToInt(Car::getDistances)
                .max()
                .orElse(0);

    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public int getCount() {
        return count;
    }

    public int getTopDistance() {
        return topDistance;
    }
}
