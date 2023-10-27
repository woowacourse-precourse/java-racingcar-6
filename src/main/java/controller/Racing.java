package controller;

import service.InputRacingCar;
import view.PrintMessage;
import vo.RacingCars;

public class Racing {

    private RacingCars racingCars;

    public void startRacing() {
        PrintMessage.printStart();
        setRacingCar();
    }

    public void setRacingCar() {
        racingCars= InputRacingCar.setInputRacingCars();
    }
}
