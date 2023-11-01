package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Exception {
    private List<String> carNames = new ArrayList<>();
    public void checkExcessCarName(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public void checkOverlapCarName(String car) {
        if (carNames.contains(car)) {
            throw new IllegalArgumentException("중복된 이름은 입력할 수 없습니다.");
        }
        carNames.add(car);
    }


}
