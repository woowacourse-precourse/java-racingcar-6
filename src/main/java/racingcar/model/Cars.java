package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import racingcar.view.OutputView;

public class Cars {
    private final List<Car> racingCars = new ArrayList<>();

    public Cars(final String namesString) {
        String[] names = namesString.split(",");
        for (String name : names) {
            validateUniqueCarName(names);
            racingCars.add(new Car(name));
        }
    }

    public void run() {
        for (Car car : racingCars) {
            car.movePosition();
            OutputView.printString(car.getPositionString());
        }
    }

    public static void validateUniqueCarName(String[] names) {
        Set<String> set = new HashSet<>();
        for (String name : names) {
            set.add(name);
        }
        if (set.size() != names.length) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 중복되지 않게 지어주세요.");
        }
    }

    public List<String> getWinners() {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : racingCars) {
            if (car.isWinnerCondition(getMaxScore())) {
                winnerNames.add(car.toString());
            }
        }
        return winnerNames;
    }

    private int getMaxScore() {
        return racingCars.stream().mapToInt(Car::getCarPosition).max().orElseThrow(NoSuchElementException::new);
    }
}