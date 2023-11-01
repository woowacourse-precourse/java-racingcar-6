package racingcar.game;

import racingcar.Object.Car;
import racingcar.Object.Player;
import racingcar.Object.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int turn;
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private List<GameCar> gameCars;

    public Game(int turn, List<String> carNameList) {
        this.turn = turn;
        List<GameCar> gameCars = new ArrayList<>();
        for (String s : carNameList) {
            GameCar gameCar = new GameCar(s);
            gameCars.add(gameCar);
        }
        this.gameCars = gameCars;
    }

    public int getTurn(){
        return this.turn;
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

    public void displayGameScore(){
        List<Integer> gameScores = getGameScore();
        for (GameCar gameCar : this.gameCars){
            System.out.println(gameCar.getName() + " : " + "-".repeat(gameCar.getPosition()));
        }
    }

    public List<Integer> getGameScore(){
        List<Integer> gameScore = new ArrayList<>();
        for (GameCar gameCar : this.gameCars){
            gameScore.add(gameCar.getPosition());
        }
        return gameScore;
    }
}
