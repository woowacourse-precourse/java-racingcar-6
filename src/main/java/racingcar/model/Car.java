package racingcar.model;

import racingcar.view.InputUserCar;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Car {
    private CarSetting carSetting;
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

    public Map<String, Integer> goFront(){
        int num = carSetting.getTrialNumber();
        Map<String, Integer> carsSituation = carSetting.getCarsSituation();
        Iterator<String> iterator = carsSituation.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            int randomNumber = RandomPlay.randomNumberGenerator();
            carsSituation.replace(key, carsSituation.get(key)+randomNumber);
        }

        carSetting.setCarsSituation(carsSituation);
        return carsSituation;
    }




}
