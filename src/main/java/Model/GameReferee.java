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

    public ArrayList<Car> setUpCars() {
        ArrayList<Car> cars = new ArrayList<>();

        String[] carNames = carRaceInputService.getInstance().askUserCarNames();
        for (String carName : carNames
        ) {
            cars.add(new Car(carName));
        }
        return cars;

    }


}
