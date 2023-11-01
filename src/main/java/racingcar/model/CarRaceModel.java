package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;

public class CarRaceModel {

    public List<String> generateCarName(String carNames) {

        List<String> carNameList = Arrays.asList(carNames.split(","));
        HashMap<String, String> carHashMap = new HashMap<>();

        return carNameList;
    }

    public List<Car> generateCar(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();

        for(int i = 0; i < carNameList.size(); i++) {
            carList.add(new Car(carNameList.get(i)));
        }

        return carList;
    }

    public List<String> findWinner(List<Car> carList) {
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
