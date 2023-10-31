package Service;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    public static List<String> determineWinners(List<Car> carList) {
        int maxRaceCount = 0;
        for (Car car : carList) {
            maxRaceCount = Math.max(maxRaceCount, car.getRaceCount());
        }

        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getRaceCount() == maxRaceCount) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}