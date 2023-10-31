package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }

    public void play(){
        CarService carService = new CarService();
        String carNames = racingCarView.promptForNames();
        carService.setCars(carNames);
        Integer totalRounds = Integer.parseInt(racingCarView.promptForNumbers());
        startRace(totalRounds, carService);
        finishRace(carService);
    }

    private void startRace(Integer totalRounds, CarService carService){
        racingCarView.printRaceStart();
        for (int i = 0; i < totalRounds; i++) {
            for (Car car : carService.cars) {
                car.moveForward();
                racingCarView.printRoundResult(car);
            }
            racingCarView.printEmptyLine();
        }
    }

    private void finishRace(CarService carService){
        racingCarView.printRaceWinner(carService.getWinnerNames());
    }
}
