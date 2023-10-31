package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class RacingStatus {
    List<String> carList = new ArrayList<>();

    public void setCarList(List<String> carList){
        this.carList = carList;
    }
}
