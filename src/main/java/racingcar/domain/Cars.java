package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class Cars {
    private List<Car> carList;

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
                .map(Car::getCurrentPosition)
                .collect(Collectors.toList())
        ));
    }

    private void move() {
        carList.forEach(Car::move);
    }

    public void play() {
        move();
        getRoundResult();
    }

}
