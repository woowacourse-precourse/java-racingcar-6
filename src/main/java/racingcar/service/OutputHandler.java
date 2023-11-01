package racingcar.service;

import racingcar.domain.Car;
import java.util.*;

public class OutputHandler {

    public void printRaceResult(List<Car> cars) {
        System.out.println(" 실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getMoveDistance());
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

