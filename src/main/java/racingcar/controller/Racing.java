package racingcar.controller;

import racingcar.service.InputRacingCar;
import racingcar.view.PrintMessage;
import racingcar.vo.RacingCars;

public class Racing {

    private RacingCars racingCars;

    public void startRacing() {
        setRacingCar();

    }

    public void setRacingCar() {
        PrintMessage.printStart();
        racingCars = InputRacingCar.setInputRacingCars();
    }


}
