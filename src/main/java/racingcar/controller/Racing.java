package racingcar.controller;

import racingcar.service.InputRacingCar;
import racingcar.service.InputTryCount;
import racingcar.view.PrintMessage;
import racingcar.vo.RacingCars;

public class Racing {

    private RacingCars racingCars;
    private int tryCount;

    public void startRacing() {
        setRacingCar();
        setTryRound();
    }

    public void setRacingCar() {
        PrintMessage.printStart();
        racingCars = InputRacingCar.setInputRacingCars();
    }

    public void setTryRound() {
        PrintMessage.printTryCount();
        tryCount= InputTryCount.setInputTryCount();
    }
}
