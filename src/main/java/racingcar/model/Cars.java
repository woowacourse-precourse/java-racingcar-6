package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.view.OutputView;

public class Cars {
    private final List<Car> racingCars = new ArrayList<>();

    public Cars(final List<String> stringCars) {
        for (String stringCar : stringCars) {
            racingCars.add(new Car(stringCar));
        }
    }

    public void run() {
        for (Car car : racingCars) {
            car.movePosition();
            OutputView.printString(car.getPositionString());
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