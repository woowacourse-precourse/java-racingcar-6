package racingcar.service;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


import static racingcar.utils.RandomCalculator.calRandom;

public class CarManager {

    private static  List<String> carList;
    private static final  HashMap<String, Car> carMap = new HashMap<>();

    private static final List<String> winnerList = new ArrayList<>();


    private Integer max = 0;

    public CarManager(String carStr) {
        carList = Arrays.asList(carStr.split(","));
        for (int i = 0; i < carList.size(); i++) {
            carMap.put(carList.get(i), new Car());
        }
    }

    public List<String> getCarList() {
        return carList;
    }

    public HashMap<String, Car> getCarMap() {
        return carMap;
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
        for (HashMap.Entry entry : carMap.entrySet()) {
            Car now = (Car) entry.getValue();
            if (now.getPosition() == max) {
                winnerList.add((String) entry.getKey());
            }
        }
        return String.join(",", winnerList);
    }

    public void getState() {
        for (HashMap.Entry entry : carMap.entrySet()) {
            Car now = (Car) entry.getValue();
            printState((String) entry.getKey(), now.getPosition());
        }
        System.out.println();
    }

    private void printState(String name, Integer position) {
        String dash = "";
        for (int i = 0; i < position; i++) {
            dash += "-";
        }
        System.out.println(name + " : " + dash);
    }

}
