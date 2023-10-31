package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void printResult(List<Car> carList) {
        carList.stream()
                .forEach(car -> System.out.println(car.toString()));
    }

    public void printWinner(List<String> winnerNames) {
        String join = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + join);
    }
}
