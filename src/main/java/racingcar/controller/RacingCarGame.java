package racingcar.controller;

import static racingcar.view.Input.askCarNames;
import static racingcar.view.Print.suggestCarName;
import static racingcar.view.constant.ConstPrint.GAME_START;

import racingcar.service.CarService;

public class RacingCarGame{
    private CarService carService = CarService.getInstance();
    private String cars;
    public void startGame(){
        suggestCarName(GAME_START);
        cars = askCarNames();
        carService.parkParkingLot(cars);
    }

    private void playGame(){

    }
}
