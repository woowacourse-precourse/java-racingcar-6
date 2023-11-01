package racingcar;

import java.util.List;

public class OutputView {
    public static void printExecutionResultText() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(String result) {
        System.out.println(result);
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        List<String> winners = getWinnersName(cars);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static List<String> getWinnersName(List<Car> cars) {
        int maxPosition = getWinnersPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private static int getWinnersPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElse(0);
    }
}
