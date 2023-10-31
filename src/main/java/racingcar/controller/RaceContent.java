package racingcar.controller;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.View;

import java.util.ArrayList;
import java.util.List;

public class RaceContent {

    private Race race;
    private View raceView = new View();

    public RaceContent(Race race){
        this.race = race;
    }

    public void runRace(int countNumber){

        for (int i=0; i<countNumber; i++) {
            movingCar();
            List<String> carResults = convertList(race.getCars());
            raceView.raceResult(carResults);
        }
    }

    private List<String> convertList(List<Car> cars){

        List<String> carResult = new ArrayList<>();

        for(Car car : cars){
            carResult.add(car.toString());
        }
        return carResult;
    }

    private void movingCar(){

        for (Car car : race.getCars()) {
            race.moveCars(car.getName());
        }
    }
}
