package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingRepository {
    List<Car> carList = new ArrayList<>();

    List<Car> getCarList() {
        return carList;
    }

    void addCar(Car car) {
        carList.add(car);
    }

    /**
     * 난수 생성, 이동 여부 판별
     *
     * @return 한 차수 기준 자동차 별 이동 (0 : 정지, 1: 전진)
     */
    int[] generateRandom() {
        int[] moveArray = new int[carList.size()];
        Arrays.fill(moveArray, 0); // default : 정지

        for (int index = 0; index < carList.size(); index++) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                moveArray[index] = 1; // 전진
            }
        }
        return moveArray;
    }

    /**
     * 난수 값에 따른 차수 단위 자동차 이동
     *
     * @param moveArray 차수 단위 자동차별 이동 여부(점수 획득)
     */
    void moveCar(int[] moveArray) {
        for (int index = 0; index < carList.size(); index++) {
            carList.get(index).addScore(moveArray[index]);
        }
    }
}
