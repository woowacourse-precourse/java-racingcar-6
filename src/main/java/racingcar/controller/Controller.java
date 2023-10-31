package racingcar.controller;
import racingcar.model.Race;
import racingcar.view.View;
import java.util.List;

public class Controller {

    private Race race;
    private View raceView = new View();
    private Input input = new Input();
    private RaceContent raceContent;
    private RaceResult raceResult;

    public void startRace() {
        carInput();
        moveRace();
        winner();
    }

    private void carInput(){
        String carInput = raceView.startMeg();
        List<String> carNames = input.carInput(carInput);

        this.race = new Race(carNames.toArray(new String[0]));
        this.raceContent = new RaceContent(race);
        this.raceResult = new RaceResult(race);
    }

    private void moveRace(){
        int countNumber = raceView.countMeg();

        raceView.resultMeg();
        raceContent.runRace(countNumber);
    }

    private void winner(){
        String winnerCar = raceResult.checkWinner();
        raceView.winnerCar(winnerCar);
    }
}
