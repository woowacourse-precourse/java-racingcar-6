package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static racingcar.Constant.RacingMenu.PLUS_SCORE;

public class OutputController {
    private final Model model;
    public OutputController(Model model) {
        this.model = model;
    }

    public Map<String, String> getCarList(){
        return model.getCarList();
    }

    public int getCount(){
        return model.getCount();
    }

    public List<String> sortingCarListByScore(Map<String, String> carList) {
        List<String> carNameByKeyDesc = new ArrayList<>(carList.keySet());
        carNameByKeyDesc.sort((value1, value2) -> Integer.compare(carList.get(value2).length(), carList.get(value1).length()));
        return carNameByKeyDesc;
    }

    public void createRandomScore(Map.Entry<String, String> car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) car.setValue(car.getValue() + PLUS_SCORE);
    }
}
