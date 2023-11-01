package racingcar.domain;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

import static racingcar.domain.Util.getMaxDistance;
import static racingcar.domain.Util.printResult;

public class Racing {

    public static void doRacing(String turnCnt, List<Car> Cars) {
        int cnt = Integer.parseInt(turnCnt);
        while (cnt > 0) {
            for (Car curCar : Cars) {
                curCar.takeTurn();
                printResult(curCar);
            }
            System.out.println();
            cnt--;
        }
    }

    public static List<String> findWinner(int maxDistance, List<Car> Cars) {
        List<String> winners = new ArrayList<>();
        for (Car curCar : Cars) {
            if (curCar.distance == maxDistance) {
                winners.add(curCar.name);
            }
        }
        return winners;
    }
}
