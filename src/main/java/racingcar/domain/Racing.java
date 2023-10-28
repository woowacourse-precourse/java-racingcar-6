package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> racingCarList;
    private int racingCount;
    private List<String> winnerList;

    public Racing(List<Car> racingCarList){
        this.racingCarList = racingCarList;
        this.racingCount = 0;
        this.winnerList = new ArrayList<>();
    }
}
