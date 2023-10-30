package racingcar.model;

import java.util.*;
import java.util.stream.Collectors;

public class CarSetting {
    private Map<String, Integer> carGameSituation;
    private int trialNumber;

    public CarSetting(){
        carGameSituation = new HashMap<>();
    }

    protected CarSetting(String inputCarName){
        String[] splitCars = inputCarName.split(",");
        Arrays.stream(splitCars).map(car -> carGameSituation.put(car, 0));
    }

    public void setTrialNumber(int setInputValue){
        this.trialNumber = setInputValue;
        System.out.println();
    }

    public int getTrialNumber(){
        return trialNumber;
    }

    public Map<String, Integer> getCarsSituation(){
        return carGameSituation;
    }

    public void setCarsSituation(Map<String, Integer> newCarsSituation){
        this.carGameSituation = newCarsSituation;
    }

}
