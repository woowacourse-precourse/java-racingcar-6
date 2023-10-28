package racingcar.output;

import java.util.List;
import racingcar.Car;
import racingcar.constant.GuideTextConstant;

public class ConsoleOutput implements Output {

    @Override
    public void printText(GuideTextConstant text) {
        System.out.println(text);
    }

    @Override
    public void printExecutionResult(List<Car> carList) {
        carList.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getDistance())));
        System.out.println();
    }

    @Override
    public void printWinner(List<Car> carList) {
        int maxDistance = getMaxDistance(carList);
        List<String> winners = getWinnersNameList(carList, maxDistance);

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int getMaxDistance(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    private List<String> getWinnersNameList(List<Car> carList, int max) {
        return carList.stream()
                .filter(car -> (car.getDistance() == max))
                .map(Car::getName)
                .toList();
    }
}
