package racingcar.model;

import racingcar.view.InputUserCar;

public class Car {
    private CarSetting carSetting;
    private RandomNum randomNum;
    public Car(){

    }
    public void carsSet(){
        String inputValue = InputUserCar.inputName();
        carSetting = new CarSetting(inputValue);
    }

    public void trialSet(){
        int trial = InputUserCar.inputStringToInt(InputUserCar.inputTrialNumber());
        carSetting.setTrialNumber(trial);
    }


}
