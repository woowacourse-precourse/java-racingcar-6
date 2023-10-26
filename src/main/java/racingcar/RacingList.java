package racingcar;

import java.util.LinkedHashMap;

public class RacingList {

    private final LinkedHashMap<String, Integer> carList = new LinkedHashMap<>();

    public void inputCarList(String input) {
        String[] list = input.split(",");
        for (String s : list) {
            carList.put(s, 0);
        }
    }

    public LinkedHashMap<String, Integer> getCarList() {
        return carList;
    }
}
