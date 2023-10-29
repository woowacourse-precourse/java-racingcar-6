package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Racing {
    private List<Car> carList;
    public Racing(List<Car> carList){
        this.carList = carList;
    }
    public Boolean isGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }
}

