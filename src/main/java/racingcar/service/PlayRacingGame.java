package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Standard;

public class PlayRacingGame {
    public void play(int moveCount, List<Car> cars) {
        System.out.println();
        System.out.println("실행 결과");

        while (moveCount-- > 0) {
            for (Car car : cars) {
                int randomNum = Randoms.pickNumberInRange(0, 9);
                // 랜덤 숫자가 4보다 크다면 이동!
//                System.out.println("randomNum = " + randomNum);
                if (randomNum >= Standard.goeFour.getValue()) {
                    car.move();
                }
            }
            printCarStatus(cars);
        }
    }

    private void printCarStatus(List<Car> cars) {
        // 출력
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
        System.out.println();
    }
}
