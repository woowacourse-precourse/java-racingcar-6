package racingcar.service;

import racingcar.domain.Car;
import racingcar.utils.RandomCalculator;


import java.util.*;

import static racingcar.utils.RandomCalculator.calRandom;

public class CarManager {

    private static List<String> carList;
    private static HashMap<String, Car> carMap = new HashMap<>();

    private static List<String> winnerList = new ArrayList<>();


    private Integer max = 0;

    public CarManager(String carStr) {
        carList = Arrays.asList(carStr.split(","));
        for (int i = 0; i < carList.size(); i++) {
            carMap.put(carList.get(i), new Car());
        }
    }

    public void goOrStop() {
        for (Car now : carMap.values()) {
            if (calRandom()) {
                now.go();
            }
            if (now.getPosition() > max) {
                max = now.getPosition();
            }
        }

    }


    public String getWinnerList() {
        for (Map.Entry entry : carMap.entrySet()) {
            Car now = (Car) entry.getValue();
            if (now.getPosition() == max) {
                winnerList.add((String) entry.getKey());
            }
        }
        return String.join(",", winnerList);
    }



}
