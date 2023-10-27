package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingRepository {

    List<Car> carList = new ArrayList<>();

    void addCar(Car car) {
        carList.add(car);
    }

    List<Car> getCarList() {
        return carList;
    }

    /**
     * 난수 생성, 이동 여부 판별
     * @return 한 차수 기준 자동차별 이동 여부(점수 획득)
     */
    int[] generateRandom() {
        int[] moveArray = new int[carList.size()];
        for (int index = 0; index < carList.size(); index++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                moveArray[index] = 1;
            }
            if (Randoms.pickNumberInRange(0, 9) < 4) {
                moveArray[index] = 0;
            }
        }
        return moveArray;
    }

    /**
     * 난수 값에 따른 차수 단위 자동차 이동
     * @param moveArray 차수 단위 자동차별 이동 여부(점수 획득)
     */
    void moveCar(int[] moveArray) {
        for (int index = 0; index < carList.size(); index++){
            if (moveArray[index] == 1){
                carList.get(index).addScore();
            }
        }
    }
}
