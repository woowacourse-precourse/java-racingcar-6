package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    public static final int MIN_RANDOM_NUMBER = 0;
    public static final int MAX_RANDOM_NUMBER = 9;
    public static final int BOUNDARY_MOVE_NUMBER = 4;
    private static final String RESULT_FORMAT = "%s : %s\n";
    private static final String LOCATION_SIGN = "-";
    private static final String WINNER_FORMAT = "최종 우승자 : %s";

    public void moveCar(Car car) {
        if (isMove()) {
            car.move();
        }
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    private boolean isMove() {
        if (makeRandomNumber() < BOUNDARY_MOVE_NUMBER) {
            return false;
        }

        return true;
    }

    public String makeResult(List<Car> cars) {
        StringBuilder results = new StringBuilder();

        for (Car car : cars) {
            String name = car.getName();
            String locationSigns = makeLocationSigns(car.getLocation());
            String result = String.format(RESULT_FORMAT, name, locationSigns);

            results.append(result);
        }

        return results.toString();
    }

    private String makeLocationSigns(int location) {
        return LOCATION_SIGN.repeat(location);
    }

    public String makeWinnerResult(List<Car> cars) {
        List<String> winners = new ArrayList<>();

        int maxLocation = findMaxLocation(cars);
        List<String> winnerNames = findWinnerNames(cars, maxLocation);

        return String.format(WINNER_FORMAT, String.join(",", winnerNames));
    }

    private int findMaxLocation(List<Car> cars) {
        List<Integer> locations = cars.stream()
                .map(Car::getLocation)
                .toList();

        return Collections.max(locations);
    }

    private List<String> findWinnerNames(List<Car> cars, int maxLocation) {
        return cars.stream()
                .filter(car -> car.isWinner(maxLocation))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
