package service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameManager {

    private final List<Map.Entry<String, String>> carIdxNamePosList = new ArrayList<>();

    public List<Map.Entry<String, String>> getCarIdxNamePosList() {
        return this.carIdxNamePosList;
    }

    public void setCarIdxNamePosList(ArrayList<String> carsName) {
        for (String name : carsName) {
            Map.Entry<String, String> car = new AbstractMap.SimpleEntry<>(name, "");
            this.carIdxNamePosList.add(car);
        }
    }

    private int setRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean chkCarGoOrStop() {
        return setRandomNum() >= 4;
    }

    public void setCarsMove(int carIdx) {
        Map.Entry<String, String> car = this.carIdxNamePosList.get(carIdx);

        boolean goOrStop = chkCarGoOrStop();

        if (goOrStop) {
            String nowCarBeforePos = car.getValue();
            String newCarPos = nowCarBeforePos + "-";

            this.carIdxNamePosList.set(carIdx, new AbstractMap.SimpleEntry<>(car.getKey(), newCarPos));
        }
    }

    public void cleanup() {
        carIdxNamePosList.clear();
    }
}
