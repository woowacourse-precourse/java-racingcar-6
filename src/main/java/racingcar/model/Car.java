package racingcar.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import racingcar.view.InputUserCar;

public class Car {
    private CarSetting carSetting;

    public Car() {

    }

    public void setCars() {
        String inputValue = InputUserCar.inputName();
        carSetting = new CarSetting(inputValue);
    }

    public int setTrial() {
        int trial = InputUserCar.inputStringToInt(InputUserCar.inputTrialNumber());
        carSetting.setTrialNumber(trial);
        return trial;
    }

    public Map<String, Integer> goFront() {
        Map<String, Integer> carsSituation = carSetting.getCarsSituation();
        Iterator<String> iterator = carsSituation.keySet().iterator();
        int maxScore = 0;
        while (iterator.hasNext()) {
            String key = iterator.next();
            maxScore = getScore(carsSituation, key, maxScore);
        }

        carSetting.setCarsSituation(carsSituation);
        carSetting.setMaxScore(maxScore);
        return carsSituation;
    }

    private static int getScore(Map<String, Integer> carsSituation, String key, int maxScore) {
        int randomNumber = RandomPlay.generateRandomNumber();
        if (randomNumber >= 4) {
            carsSituation.replace(key, carsSituation.get(key) + randomNumber);
            maxScore = getMaxScore(maxScore, carsSituation, key);
        }
        return maxScore;
    }

    private static int getMaxScore(int maxScore, Map<String, Integer> carsSituation, String key) {
        if (maxScore < carsSituation.get(key)) {
            maxScore = carsSituation.get(key);
        }
        return maxScore;
    }

    public static List<String> getResultWinner() {
        return CarSetting.findFinalWinner();
    }

}
