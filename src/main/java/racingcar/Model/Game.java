package racingcar.Model;

import racingcar.View.carRaceOutputService;
import java.util.ArrayList;

public class Game {

    private static Game game = null;
    private int round = 0;

    private ArrayList<Car> cars;

    private Game() {

    }

    public static Game getInstance() {
        if (Game.game == null) {
            return Game.game = new Game();
        }
        return Game.game;
    }


    public int getRound() {
        return this.round;
    }

    public void playGame() {
        GameReferee.getInstance().setUpGameRound();
        this.cars = GameReferee.getInstance().setUpCars();

        while (GameReferee.getInstance().continueGame()) {
            for (Car car : cars
            ) {
                car.race();
                GameReferee.getInstance().setMaxScore(car.getMoves());
            }
        }
        carRaceOutputService.getInstance().printRaceResult(GameReferee.getInstance().selectWinners(this.cars));
    }


}
