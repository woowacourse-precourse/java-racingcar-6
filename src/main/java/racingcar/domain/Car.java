package racingcar.domain;


import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Car {
    private LinkedHashMap<String, String> carList;

    public LinkedHashMap<String, String> getCarList() {
        return carList;
    }

    public void setCarList(LinkedHashMap<String, String> carList) {
        this.carList = carList;
    }

    public void getCurrentRacingResult() {
        getCarList().forEach((key, value) -> {
            System.out.println(key + " :" + " " + value);
        });
    }

    public String getFinalWinner() {
        ArrayList<String> winnerList = new ArrayList<>();
        int maxValue = 0;
        for (String value : getCarList().values()) {
            if (value.length() > maxValue) {
                maxValue = value.length();
            }
        }

        for (String key : getCarList().keySet()) {
            if (getCarList().get(key).length() == maxValue) {
                winnerList.add(key);
            }
        }

        String winners = String.join(", ", winnerList);

        return winners;
    }
}
