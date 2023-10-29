package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {
    public static void printAllResults(List<List<String>> allResults) {
        System.out.println("\n실행 결과");
        for (List<String> roundResults : allResults) {
            for (String result : roundResults) {
                System.out.println(result);
            }
            System.out.println();
        }
    }

    public static void printWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println("\n최종 우승자 : " + String.join(", ", winners));
    }

}

