package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    public List<String> determineWinner(List<Car> carList) {
        int maxMove = getMaxMoveCount(carList);
        return getWinnerCarNameList(carList, maxMove);
    }

    private int getMaxMoveCount(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getMove)
                .max()
                .orElse(0);
    }

    private List<String> getWinnerCarNameList(List<Car> carList, int maxMove) {
        return carList.stream()
                .filter(car -> car.getMove() == maxMove)
                .map(Car::getCarName)
                .toList();
    }

}
