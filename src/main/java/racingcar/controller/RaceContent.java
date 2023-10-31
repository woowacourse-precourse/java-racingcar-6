package racingcar.controller;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.View;

public class RaceContent {

    private Race race;
    private View raceView = new View();

    public RaceContent(Race race){
        this.race = race;
    }

    public void runRace(int countNumber){
        for (int i=0; i<countNumber; i++) {
            movingCar();
            raceView.raceResult(race.getCars());
        }
    }

    private void movingCar(){
        for (Car car : race.getCars()) {
            race.moveCars(car.getName());
        }
    }
}
