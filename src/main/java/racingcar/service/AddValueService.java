package racingcar.service;

import java.util.ArrayList;
import java.util.List;

public class AddValueService {
    public String[] carNameList;
    public int countValue;

    public String[] addCarNames(String carNames) {
        carNameList = carNames.split(",");
        return carNameList;
    }

    public int addCarCount(String count){
        countValue = Integer.parseInt(count);
        return countValue;
    }

}
