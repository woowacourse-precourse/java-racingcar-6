package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.GameMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveCnt;

import java.util.ArrayList;
import java.util.List;

public class CarMove {
    // 각각의 레이스 결과를 모두 담은 리스트를 반환하는 메서드
    public List<Cars> race(Cars cars, MoveCnt moveCnt) {
        List<Cars> allRaceResultList = new ArrayList<>(); // Car 클래스는 자동차 명, 이동거리를 멤버변수로 가짐

        // 첫 번째 이동 계산해서 리스트에 저장
        allRaceResultList.add(eachMove(cars));

        // 두 번째 이동부터는 eachMove 메서드의 매개변수로 이전 이동 결과 리스트를 전달
        // (=> 이동 거리가 누적되도록 하기 위해서)
        for (int i = 1; i < moveCnt.getMoveCnt(); i++) {
            allRaceResultList.add(eachMove(allRaceResultList.get(i - 1)));
        }

        return allRaceResultList;
    }

    // 한 번의 레이스 결과 리스트를 반환하는 메서드
    public Cars eachMove(Cars cars) {
        List<Car> raceResult = new ArrayList<>();

        for (Car car : cars) {
            boolean go = decideMove(pickRandNum());  // 난수 생성해서 해당 자동차의 이동 여부 결정
            String carName = car.getName();
            int carDist = car.getDist();

            if (go) {
                raceResult.add(new Car(carName, carDist + 1));
            } else {
                raceResult.add(new Car(carName, carDist));
            }
        }

        return new Cars(raceResult);
    }

    // 앞으로 이동 여부 결정하는 메서드
    public boolean decideMove(int digit) {
        if (digit >= GameMessage.GO_MIN_VALUE) {
            return true;
        }
        return false;
    }

    public int pickRandNum() {
        return Randoms.pickNumberInRange(GameMessage.GO_RAND_NUM_MIN_SIZE,
                GameMessage.GO_RAND_NUM_MAX_SIZE);
    }

}
