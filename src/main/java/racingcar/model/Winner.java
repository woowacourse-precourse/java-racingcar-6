package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private List<String> winnerCarList = new ArrayList<>();

    public List<String> determineWinner(List<Car> carList) {
       int maxMove = carList.stream()
               .mapToInt(Car::getMove)
               .max()
               .orElse(0);

       winnerCarList = carList.stream()
               .filter(car -> car.getMove() == maxMove)
               .map(Car::getCarName)
               .toList();

        return winnerCarList;
    }

}
