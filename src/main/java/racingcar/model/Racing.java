package racingcar.model;

import racingcar.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {
    private final NumberGenerator numberGenerator;

    public Racing(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void moveCar(List<Car> carList) {
        for (Car car : carList) {
            car.move(numberGenerator.createNumber());
        }
    }

    public List<String> winnerNameList(List<Car> carList) {
        List<Car> winnerList = findWinner(carList);
        List<String> winnerName = new ArrayList<>();

        for (Car car : winnerList) {
            winnerName.add(car.getName());
        }

        return winnerName;
    }

    private List<Car> findWinner(List<Car> carList) {
        List<Integer> carPosition = new ArrayList<>();
        List<Car> winnerList;

        makePositionList(carList, carPosition);
        int max = Collections.max(carPosition);
        winnerList = getWinner(carList, max);

        return winnerList;
    }

    private List<Car> getWinner(List<Car> carList, int max) {
        List<Car> winnerList = new ArrayList<>();

        for (Car car : carList) {
            if (car.getPosition() == max) {
                winnerList.add(car);
            }
        }

        return winnerList;
    }

    private void makePositionList(List<Car> carList, List<Integer> carPosition) {
        for (Car car : carList) {
            carPosition.add(car.getPosition());
        }
    }
}
