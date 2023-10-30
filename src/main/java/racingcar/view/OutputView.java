package racingcar.view;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public static void printInfo(String message) {
        System.out.print(message);
    }

    public static void printResult(List<Car> carList) {
        for (Car car : carList) {
            StringBuilder resultBuilder = new StringBuilder();
            resultBuilder.append(car.getName()).append(" : ");
            for (int i = 0; i < car.getMoveCount(); i++) {
                resultBuilder.append('-');
            }
            System.out.println(resultBuilder);
        }
        System.out.println();
    }

    public static void printWinner(List<Car> carList) {
        Collections.sort(carList, Comparator.comparing(Car::getMoveCount).reversed());

        int index = 0;
        StringBuilder winnerBuilder = new StringBuilder();
        winnerBuilder.append("최종 우승자 : ").append(carList.get(index++).getName());
        while (index < carList.size() && carList.get(index - 1).getMoveCount() == carList.get(index).getMoveCount()) {
            winnerBuilder.append(", ").append(carList.get(index).getName());
            index++;
        }

        System.out.println(winnerBuilder);
    }
}
