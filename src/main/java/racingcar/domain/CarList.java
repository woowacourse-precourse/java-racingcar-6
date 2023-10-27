package racingcar.domain;

import static racingcar.view.RacingView.carMoveOrStopDecisionResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.utill.RandomNumberGenerator;

public class CarList {

    private final List<Car> carList;

    public CarList(List<Car> carList) {
        this.carList = carList;
    }

    public void carsStopOrMoveDecisionCall() {
        for (Car car : carList) {
            int carPosition = car.stopOrMoveDecision(RandomNumberGenerator.createRandomNumber());
            String carName = car.getCarName();
            carMoveOrStopDecisionResultView(carName, carPosition);
        }
    }

    public String racingWinnerDecision() {
        Map<String, Integer> rankingMap = carList.stream()
                .collect(Collectors.toMap(Car::getCarName, Car::getCarPosition));
        List<String> winnerList = findWinner(rankingMap);
        return (stringListToString(winnerList));
    }

    private List<String> findWinner(Map<String, Integer> rankingMap) {
        List<String> winnerList = new ArrayList<>();
        Integer maxPosition = Collections.max(rankingMap.values());
        for (String carName : rankingMap.keySet()) {
            if (rankingMap.get(carName).equals(maxPosition)) {
                winnerList.add(carName);
            }
        }
        return winnerList;
    }

    private String stringListToString(List<String> stringList) {
        return String.join(", ", stringList);
    }

    @Override
    public String toString() {
        return carList.toString();
    }
}
