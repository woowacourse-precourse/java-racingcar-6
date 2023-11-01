package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.model.RaceNumber;
import racingcar.view.GameView;

import java.util.Arrays;

public class Controller {
    GameView gameView;
    Race race;
    public static Controller init(GameView gameView){
        return new Controller(gameView,new Race());
    }

    public void RunGame(){
        RaceNumber raceNumber = RaceNumber.of(gameView.requestAttemptsNum());
        gameView.printPreResultMessage();
        for(int i = 0; i < raceNumber.count(); i++){
            race.run();
            gameView.printResult(race.toResult());
        }
        gameView.printWinner(race.getWinner());
    }

    private Controller(GameView gameView, Race race) {
        this.gameView = gameView;
        this.race = race;
        String names = gameView.requestCarInputRequest();
        Arrays.stream(names.split(","))
                .map(Car::of)
                .forEach(race::addCar);
    }
}
