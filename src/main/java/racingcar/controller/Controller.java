package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.View;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Race race;
    private View raceView = new View();

    public void startRace() {
        carInput();
        runRace();
        winner();
    }

    private void carInput(){

        String carInput = raceView.startMeg();
        List<String> carNames = splitNames(carInput);

        this.race = new Race(carNames.toArray(new String[0]));
    }

    private void runRace(){

        int countNumber = raceView.countMeg();

        raceView.resultMeg();
        for (int i=0; i<countNumber; i++) {
            movingCar();
        }
    }

    private void movingCar(){

        for (Car car : race.getCars()) {
            race.moveCars(car.getName());
        }
        raceView.raceResult(race.getCars());
    }

    private void winner(){
        String winnerCar = checkWinner();
        raceView.winnerCar(winnerCar);
    }

    private List<String> splitNames(String carInput) {

        String[] carArray = carInput.split(",");
        List<String> carNames = new ArrayList<>();

        for (String carName : carArray) {
            carNames.add(carName.trim());
        }
        return carNames;
    }

    private int maxCount() {

        int maxMove = -1;

        for (Car car : race.getCars()) {

            if (car.getMove() > maxMove) {
                maxMove = car.getMove();
            }
        }
        return maxMove;
    }

    private String checkWinner() {

        int maxMove = maxCount();
        List<String> winnerCar = new ArrayList<>();

        for (Car car : race.getCars()) {

            if (car.getMove() == maxMove) {
                winnerCar.add(car.getName());
            }
        }
        return String.join(", ", winnerCar);
    }
}
