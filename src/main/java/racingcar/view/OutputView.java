package racingcar.view;

import racingcar.domain.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printResult(List<Car> carList){
        carList.stream()
                .forEach(car -> System.out.println(car.toString()));
    }

    public void printWinner(List<Car> carList){
        int maxMoveNumber = carList.stream()
                .mapToInt(Car::getMoveNumber)
                .max()
                .orElseThrow(() -> new IllegalArgumentException());

        List<String> winnerNames = carList.stream()
                .filter(car -> car.isMaxMoveNumber(maxMoveNumber))
                .map(car -> car.getName())
                .collect(Collectors.toList());

        String join = String.join(", ", winnerNames);

        System.out.println("최종 우승자 : " + join);


    }
}
