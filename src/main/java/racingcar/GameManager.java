package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private User user;
    private List<String> winnerCars = new ArrayList<>();

    public GameManager(User user) {
        this.user = user;
    }

    public String announceWinner() {
        int longestDistance = getLongestDistance();
        getWinnerCars(longestDistance);
        return String.join(", ", winnerCars);
    }

    private void getWinnerCars(int longestDistance) {
        // 가장 긴 주행거리랑 일치하는 자동차를 구한다.
        for (Car car : user.getCarList()) {
            addCarWhichHasLongestDistance(longestDistance, car);
        }
    }

    private void addCarWhichHasLongestDistance(int longestDistance, Car car) {
        if (longestDistance == car.getDistanceDriven().length()) {
            winnerCars.add(car.getCarName());
        }
    }

    private int getLongestDistance() {
        int longestDistance = -1;
        // 가장 긴 주행거리를 구한다.
        for (Car car : user.getCarList()) {
            longestDistance = initLongestDistance(longestDistance, car);
        }
        return longestDistance;
    }

    private static int initLongestDistance(int longestDistance, Car car) {
        if (longestDistance < car.getDistanceDriven().length()) {
            longestDistance = car.getDistanceDriven().length();
        }
        return longestDistance;
    }
}
