package racingcar.controller;

import racingcar.service.InputRacingCar;
import racingcar.service.InputTryCount;
import racingcar.service.RacingLogic;
import racingcar.view.PrintMessage;
import racingcar.vo.RacingCars;

public class Racing {

    private RacingCars racingCars;
    private int tryCount;

    public void startRacing() {
        setRacingCar();
        setTryRound();
        setRacingResult();
        setRacingWinner();
    }

    public void setRacingCar() {
        PrintMessage.printStart();
        racingCars = InputRacingCar.setInputRacingCars();
    }

    public void setTryRound() {
        PrintMessage.printTryCount();
        tryCount = InputTryCount.setInputTryCount();
    }

    public void setRacingResult() {
        PrintMessage.printResultStart();
        for (int i = 0; i < tryCount; i++) {
            RacingLogic.goRacing(racingCars);
        }
    }

    public void setRacingWinner() {
        RacingLogic.determineRacingWinner(racingCars);
    }


}
