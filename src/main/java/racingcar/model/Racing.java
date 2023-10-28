package racingcar.model;

import java.util.List;

public class Racing {
    private final int tryCnt;
    private final List<Car> carList;
    private int trialNum = 0;

    public Racing(int tryCnt, List<Car> carList) {
        this.tryCnt = tryCnt;
        this.carList = carList;
    }

    public void plusTrialNumber() { // 횟수 증가
        this.trialNum += 1;
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
