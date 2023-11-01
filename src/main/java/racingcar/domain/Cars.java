package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.NumberGenerator;
import racingcar.utils.Util;
import racingcar.view.OutputView;

public class Cars {
    private List<Car> carList;
    NumberGenerator numberGenerator = new Driver();

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public void findWinners() {
        Car farthestCar = findFarthestCar();
        OutputView.printWinner(String.join(", ", findCoWinner(farthestCar)));
    }

    private Car findFarthestCar() {
        return carList.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량 리스트가 비었습니다."));
    }

    private List<String> findCoWinner(Car farthestCar) {
        return carList.stream()
                .filter(farthestCar::isSamePosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void getRoundResult() {
        OutputView.printRoundResult(new ArrayList<>(carList.stream()
                .map(car -> car.getName() + " : " + Util.dashGenerator(car.getPosition()))
                .collect(Collectors.toList())
        ));
    }

    private void move() {
        carList.forEach(car -> car.move(numberGenerator));
    }

    public void play() {
        move();
        getRoundResult();
    }

}
