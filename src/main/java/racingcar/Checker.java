package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Checker {
    public static Boolean isNameAllCorrect(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                return false;
            }
        }

        return true;
    }

    public static List<String> judgeWinners(List<Car> cars) {
        Integer highestScore = cars.stream()
                .mapToInt(car -> car.getScore())
                .max().orElseThrow(() -> new NoSuchElementException());

        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getScore() == highestScore) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
