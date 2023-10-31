package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarManager;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }

    public void play(){
        CarManager carManager = new CarManager();
        String carNames = racingCarView.promptForNames();
        carManager.setCars(carNames);
        Integer totalRounds = Integer.parseInt(racingCarView.promptForNumbers());
        startRace(totalRounds, carManager);
        finishRace(carManager);
    }

    private void startRace(Integer totalRounds, CarManager carManager){
        racingCarView.printRaceStart();
        for (int i = 0; i < totalRounds; i++) {
            for (Car car : carManager.cars) {
                car.moveForward();
                racingCarView.printRoundResult(car);
            }
            racingCarView.printEmptyLine();
        }
    }

    private void finishRace(CarManager carManager){
        racingCarView.printRaceWinner(carManager.getWinnerNames());
    }
}
