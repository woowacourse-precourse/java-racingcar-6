package racingcar.domain;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public static int findFarthestCarPosition(List<Car> carList) {
        int farthestCarPosition = 0;

        for (Car car : carList) {
            // car.get().len() 수정 ->  Car 클래스에 position int로 받는거랑 str으로 저장 둘 다?
            farthestCarPosition = Math.max(farthestCarPosition, car.getPositionInt());
        }

        return farthestCarPosition;
    }

    public static List<String> winnerList(List<Car> carList, int farthestCarPosition) {
        List<String> winner = new ArrayList<>();

        for (Car car : carList) {
            if (car.getPositionInt() == farthestCarPosition) {
                winner.add(car.getName());
            }
        }

        return winner;
    }
}
