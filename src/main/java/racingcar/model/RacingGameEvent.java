package racingcar.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.vo.Car;

public class RacingGameEvent {

    private Map<Car, List<Integer>> positionHistory = new LinkedHashMap<>();

    public Map<Car, List<Integer>> getPositionHistory() {
        return positionHistory;
    }

    public RacingGameEvent(String[] cars) {
        for (String carName : cars) {
            positionHistory.put(new Car(carName), new ArrayList<>());
        }
    }


    public void startEvent(int attempt) {
        for (int i = 0; i < attempt; i++) {
            positionHistory.forEach((k, v) -> v.add(k.moveForward(new MoveForward().success())));
        }
    }

    public List<String> getWinnerNames(Map<Car, List<Integer>> positionHistory) {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition(positionHistory);
        for (Car car : positionHistory.keySet()) {
            getWinnerName(winners, maxPosition, car);
        }
        return winners;
    }

    private static int getMaxPosition(Map<Car, List<Integer>> positionHistory) {
        int maxPosition = 0;
        for (Car car : positionHistory.keySet()) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private static void getWinnerName(List<String> winners, int maxPosition, Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }
}
