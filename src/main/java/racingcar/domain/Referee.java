package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Referee {

    // Distance 를 기준으로 내림차순 정렬하는 기능
    public List<Car> selectWinnerList(List<Car> list) {
        Collections.sort(list, (o1, o2) -> {
            if (o1.getDistance() > o2.getDistance()) {
                return -1;
            }
            if (o1.getDistance() < o2.getDistance()) {
                return 1;
            }
            return o1.getDistance().compareTo(o2.getDistance());
        });
        return list;
    }
}
