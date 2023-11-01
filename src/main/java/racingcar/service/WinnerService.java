package racingcar.service;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerService {
    public static void announceWinners(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            int position = car.getPosition();
            if (position > maxPosition) {
                maxPosition = position;
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners).trim());
    }
}
