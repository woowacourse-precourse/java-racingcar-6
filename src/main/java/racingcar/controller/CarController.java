package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.CarService;
import racingcar.views.InputView;
import racingcar.views.OutputView;

import java.util.List;

public class CarController {

    public CarService carService;

    public void startGame(){
        carService.inputGame();
    }





}
