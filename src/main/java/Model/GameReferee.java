package Model;

import View.carRaceInputService;
import java.util.ArrayList;

public class GameReferee {

    private static GameReferee gameReferee = null;

    private int totalRound;

    private int maxScore = 0;

    public static GameReferee getInstance() {
        if (GameReferee.gameReferee == null) {
            return GameReferee.gameReferee = new GameReferee();
        }
        return GameReferee.gameReferee;
    }

    public void setUpGameRound() {
        this.totalRound = carRaceInputService.getInstance().askUserGameRound();
    }

    public void setMaxScore(int score) {
        if(maxScore < score)
            this.maxScore = score;
    }

    public ArrayList<Car> setUpCars() {
        ArrayList<Car> cars = new ArrayList<>();

        String[] carNames = carRaceInputService.getInstance().askUserCarNames();
        for (String carName : carNames
        ) {
            cars.add(new Car(carName));
        }
        return cars;

    }

    public boolean continueGame() {
        return Game.getInstance().getRound() < totalRound;
    }

    public ArrayList<Car> selectWinners(ArrayList<Car> cars) {
        ArrayList<Car> winners = new ArrayList<>();

        for (Car car : cars
        ) {
            if (car.getMoves() == this.maxScore) {
                winners.add(car);
            }
        }
        return cars;
    }

}
