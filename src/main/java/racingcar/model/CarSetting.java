package racingcar.model;

import java.util.*;
import java.util.stream.Collectors;

public class CarSetting {
    private static Map<String, Integer> carGameSituation;
    private int trialNumber;
    private static int maxScore;

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

    public void setMaxScore(int scoreValue){
        this.maxScore = scoreValue;
    }

    public static List<String> findFinalWinner(){
        List<String> maxScoreUser = new ArrayList<>();
        Iterator<String> iterator = carGameSituation.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            if(carGameSituation.get(key) == maxScore){
                maxScoreUser.add(key);
            }
        }
        return maxScoreUser;
    }

}
