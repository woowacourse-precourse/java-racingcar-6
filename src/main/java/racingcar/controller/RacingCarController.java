package racingcar.controller;

import racingcar.util.RandomNumber;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.view.RacingCarView;

public class RacingCarController {

    private final RacingCarView racingCarView;
    private final CarService carService;

    public RacingCarController(RacingCarView racingCarView, CarService carService) {
        this.racingCarView = racingCarView;
        this.carService = carService;
    }

    public void play(){
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
                car.moveForward(RandomNumber.getNumber());
                racingCarView.printRoundResult(car);
            }
            racingCarView.printEmptyLine();
        }
    }

    private void finishRace(CarService carService){
        racingCarView.printRaceWinner(carService.getWinnerNames());
    }
}
