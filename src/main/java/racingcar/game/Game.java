package racingcar.game;

import racingcar.Object.Car;
import racingcar.Object.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int turn;
    private List<GameCar> gameCars;
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public Game(int turn, List<String> carNameList) {
        this.turn = turn;
        List<GameCar> gameCars = new ArrayList<>();
        for (String s : carNameList) {
            GameCar gameCar = new GameCar(s);
            gameCars.add(gameCar);
        }
        this.gameCars = gameCars;
    }

    public void moveGameCars() {
        for (GameCar gameCar : this.gameCars) {
            if (this.determineCarMovement()) {
                gameCar.move();
            }
        }
    }
    private Boolean determineCarMovement() {
        this.randomNumberGenerator.rerollRandomNumber();
        return this.randomNumberGenerator.isGreaterThanOrEqualToThree();
    }

}
