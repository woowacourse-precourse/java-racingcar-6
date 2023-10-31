package racingcar.model;

import racingcar.view.InputUserCar;

import java.util.Arrays;
import java.util.Collection;
import java.util.*;

public class Car {
    private CarSetting carSetting;
    public Car(){

    }
    public void carsSet(){
        String inputValue = InputUserCar.inputName();
        carSetting = new CarSetting(inputValue);
    }

    public int trialSet(){
        int trial = InputUserCar.inputStringToInt(InputUserCar.inputTrialNumber());
        carSetting.setTrialNumber(trial);
        return trial;
    }

    public Map<String, Integer> goFront(){
        Map<String, Integer> carsSituation = carSetting.getCarsSituation();
        Iterator<String> iterator = carsSituation.keySet().iterator();
        int maxScore = 0;
        while(iterator.hasNext()){
            String key = iterator.next();
            int randomNumber = RandomPlay.randomNumberGenerator();
            if(randomNumber>=4) {
                carsSituation.replace(key, carsSituation.get(key) + randomNumber);
                maxScore = getMaxScore(maxScore, carsSituation, key);
            }
        }

        carSetting.setCarsSituation(carsSituation);
        carSetting.setMaxScore(maxScore);
        return carsSituation;
    }

    private static int getMaxScore(int maxScore, Map<String, Integer> carsSituation, String key) {
        if(maxScore < carsSituation.get(key)){
            maxScore = carsSituation.get(key);
        }
        return maxScore;
    }

    public List<String> resultWinner(){
        return carSetting.findFinalWinner();
    }




}
