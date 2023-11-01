package racingcar.domain;

import static racingcar.domain.dto.GameResult.createGameResult;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.dto.GameResult;

public class Game {
    private List<Car> carList;
    private int count;

    private Game(){}

    public static Game createGame(List<Car> carList, int count){
        Game game = new Game();
        game.carList = carList;
        game.count = count;

        return game;
    }

    public void playGame() {
        updateCarsMove();
    }

    private void updateCarsMove() {
        for (Car car : carList) {
            car.moveForward();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getCount() {
        return count;
    }
}
