package racingcar.game;

import racingcar.Object.Car;
import racingcar.Object.Player;
import racingcar.Object.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Game {
    private final int turn;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final List<GameCar> gameCars;

    public Game(int turn, List<String> carNameList) {
        this.turn = turn;
        List<GameCar> gameCars = new ArrayList<>();
        for (String s : carNameList) {
            GameCar gameCar = new GameCar(s);
            gameCars.add(gameCar);
        }
        this.gameCars = gameCars;
    }

    public int getTurn() {
        return this.turn;
    }

    public void moveGameCars() {
        for (GameCar gameCar : this.gameCars) {
            if (this.randomNumberGenerator.isGreaterThanOrEqualToThree()) {
                gameCar.move();
            }
            this.randomNumberGenerator.rerollRandomNumber();
        }
    }
    public void displayGameScore() {
        for (GameCar gameCar : this.gameCars) {
            System.out.println(gameCar.getName() + " : " + "-".repeat(gameCar.getPosition()));
        }
    }

    public List<Integer> getGameScore() {
        List<Integer> gameScore = new ArrayList<>();
        for (GameCar gameCar : this.gameCars) {
            gameScore.add(gameCar.getPosition());
        }
        return gameScore;
    }

    public void displayGameWinner() {
        HashMap<String, Integer> gameCarNamePositionMap = new HashMap<>();

        for (GameCar gameCar : this.gameCars) {
            gameCarNamePositionMap.put(gameCar.getName(), gameCar.getPosition());
        }

        List<String> gameCarNamePositionMapKeyList = new ArrayList<>(gameCarNamePositionMap.keySet());

        gameCarNamePositionMapKeyList.sort((o1, o2) -> gameCarNamePositionMap.get(o2).
                compareTo(gameCarNamePositionMap.
                        get(o1)));

        System.out.print("최종 우승자 : " + gameCarNamePositionMapKeyList.get(0));
        int winnerScore = gameCarNamePositionMap.get(gameCarNamePositionMapKeyList.get(0));
        for (int i = 1; i < gameCarNamePositionMapKeyList.size(); i++) {
            if (winnerScore <= gameCarNamePositionMap.get(gameCarNamePositionMapKeyList.get(i))) {
                System.out.print(", " + gameCarNamePositionMapKeyList.get(i));
            }
        }
    }
}
