package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Comparator {

    // 자동차들 중 가장 멀리 가있는 자동차들을 반환한다.
    public static List<Car> compare(List<Car> carList) {
        // Max 값 찾기
        int maxDist = 0;
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getDistance() > maxDist)
                maxDist = carList.get(i).getDistance();
        }

        // Max 값이랑 같은 Car 찾기
        List<Car> retCarList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getDistance() == maxDist)
                retCarList.add(carList.get(i));
        }

        return retCarList;
    }
}
