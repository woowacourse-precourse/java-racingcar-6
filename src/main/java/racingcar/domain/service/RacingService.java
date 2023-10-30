package racingcar.domain.service;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.generator.NumberGenerator;
import racingcar.domain.referee.InGameReferee;

public class RacingService {
    public void startRacing() {
        // TODO: 2023-10-30 Car 입력 받기. n번 입력 받은 만큼 getResultByOneTurn 실행
    }

    private void getResult(List<Car> carList) {
        List<Integer> randomList = NumberGenerator.createListNumber(carList.size());
        runRacing(carList, randomList);
        // TODO: 2023-10-30 턴마다 출력
    }

    /**
     * 생성된 무작위 값이 4이상이면 전진
     *
     * @param carList    입력받은 자동차들
     * @param randomList 생성된 랜덤 숫자들
     */
    private void runRacing(List<Car> carList, List<Integer> randomList) {
        for (int index = 0; index < carList.size(); index++) {
            if (InGameReferee.isBiggerLowerLimit(randomList.get(index))) {
                Car car = carList.get(index);
                car.forward();
            }
        }
    }
}
