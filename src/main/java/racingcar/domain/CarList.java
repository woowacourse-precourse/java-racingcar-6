package racingcar.domain;

import static racingcar.utill.Converter.stringListToStringConvert;
import static racingcar.view.RacingView.carMoveOrStopDecisionResultView;
import static racingcar.view.RacingView.newLine;

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

    public void racing(int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            carsStopOrMoveDecisionCall();
        }
    }

    public String racingWinnerDecision() {
        Map<String, Integer> rankingMap = carList.stream()
                .collect(Collectors.toMap(Car::getCarName, Car::getCarPosition));
        List<String> winnerList = findWinner(rankingMap);
        return (stringListToStringConvert(winnerList));
    }

    private void carsStopOrMoveDecisionCall() {
        for (Car car : carList) {
            int carPosition = car.stopOrMoveDecision(RandomNumberGenerator.createRandomNumber());
            String carName = car.getCarName();
            carMoveOrStopDecisionResultView(carName, carPosition);
        }

        newLine();
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

    @Override
    public String toString() {
        return carList.toString();
    }
}
