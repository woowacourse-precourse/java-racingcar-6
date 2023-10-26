package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void printResult(List<Car> carList){
        carList.stream()
                .forEach(car -> System.out.println(car.toString()));
    }
}
