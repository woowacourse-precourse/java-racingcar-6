package racingcar.repository;

import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static racingcar.view.CommonMessage.ERROR_MESSAGE_PREFIX;

public class CarRepository {

    private static final List<Car> cars = new ArrayList<>();

    public static void makeCars(List<String> carsNames) {
        validateNotEmpty(carsNames);
        validateOverlappedName(carsNames);
        carsNames.forEach(carName -> cars.add(new Car(carName)));
    }

    public static Map<String, Integer> move(NumberGenerator numberGenerator) {
        Map<String, Integer> moveResults = new LinkedHashMap<>();
        cars.forEach(car ->
                moveResults.put(car.getName(), car.movePosition(numberGenerator.generate()))
        );
        return moveResults;
    }

    public static List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        for (Car targetCar: cars) {
            long count = cars.stream().filter(targetCar::lessMoveThan).count();
            if (count == 0) {
                winners.add(targetCar.getName());
            }
        }
        return winners;
    }

    private static void validateNotEmpty(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "아무것도 입력하지 않았습니다.");
        }
    }

    private static void validateOverlappedName(List<String> names) {
        long distinctNamesCount = names.stream()
                .distinct()
                .count();
        if (distinctNamesCount != names.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "중복된 자동차 이름이 있습니다.");
        }
    }
}