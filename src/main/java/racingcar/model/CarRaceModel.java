package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;

public class CarRaceModel {

    public List<String> findWinner(HashMap<String, String> carList) {
        List<String> winner = new ArrayList<>();
        int topMovement = findTopMovement(carList);
        HashMap<String, Integer> parsedCarList = parsCarMovement(carList);

        for(Entry<String, Integer> entry : parsedCarList.entrySet()) {
            if(entry.getValue() == topMovement) {
                winner.add(entry.getKey());
            }
        }
        return winner;
    }

    public int findTopMovement(HashMap<String, String> carList) {

        HashMap<String, Integer> parsedCarList = parsCarMovement(carList);

        int winnerValue = 0;

        for(String key : parsedCarList.keySet()){
            if(parsedCarList.get(key) >= winnerValue) {
                winnerValue = parsedCarList.get(key);
            }
        }
        return winnerValue;
    }

    public HashMap<String, Integer> parsCarMovement(HashMap<String, String> carList) {
        HashMap<String, Integer> parsingCarList = new HashMap<>();

        for(String key : carList.keySet()) {
            int carMovementValue = carList.get(key).length();

            parsingCarList.put(key, carMovementValue);
        }

        return parsingCarList;
    }

    public HashMap<String, String> saveCarMovement(HashMap<String, String> carList) {

        for(Entry<String, String> entry : carList.entrySet()) {
            if(controlCarMovement()) {
                String carName = entry.getKey();
                String carMovement = entry.getValue() + "-";

                carList.put(carName, carMovement);
            }
        }
        return carList;
    }

    public boolean controlCarMovement() {
        if(Randoms.pickNumberInRange(0,9)>=4) {
            return true;
        }
        return false;
    }

}
