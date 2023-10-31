package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.global.ErrorMessage;
import racingcar.global.RaceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static racingcar.global.Constant.*;

public class CarGroup {
    private final List<CarDto> cars;

    private CarGroup(List<CarDto> cars) {
        this.cars = cars;
    }

    // Creating instance method for factory pattern
    public static CarGroup from(String carNamesCombinedWithComma) {
        List<CarDto> cars = new ArrayList<>();
        for (String carName : carNamesCombinedWithComma.split(",")) {
            String trimmedCarName = carName.trim();
            validateLength(trimmedCarName);
            validateDuplicate(cars, trimmedCarName);
            validateEmpty(trimmedCarName);
            cars.add(new CarDto(trimmedCarName, 0));
        }
        return new CarGroup(cars);
    }

    private static void validateLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw RaceException.of(ErrorMessage.EXCEED_CAR_NAME_LENGTH);
        }
    }

    private static void validateDuplicate(List<CarDto> cars, String carName) {
        if (cars.stream().anyMatch(carDto -> carDto.getName().equals(carName))) {
            throw RaceException.of(ErrorMessage.DUPLICATED_CAR_NAME);
        }
    }

    private static void validateEmpty(String carName) {
        if (carName.isEmpty()) {
            throw RaceException.of(ErrorMessage.EMPTY_CAR_NAME);
        }
    }

    public void moveAllProbabilistically() {
        cars.forEach(carDto -> {
            if (Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX) >= RANDOM_NUMBER_THRESHOLD) {
                carDto.setPosition(carDto.getPosition() + 1);
            }
        });
    }

    public String getStatusAsString() {
        List<String> results = cars
                .stream()
                .map(carDto -> String.format("%s : %s", carDto.getName(), "-".repeat(carDto.getPosition())))
                .toList();
        return String.join("\n", results);
    }

    public String getWinnerAsString() {
        Optional<Integer> winnerPositionOptional = cars.stream().map(CarDto::getPosition).max(Integer::compareTo);
        if (winnerPositionOptional.isEmpty()) {
            return "";
        }
        int winnerPosition = winnerPositionOptional.get();
        List<String> winners = cars
                .stream()
                .filter(carDto -> carDto.getPosition() == winnerPosition)
                .map(CarDto::getName)
                .toList();
        return String.join(", ", winners);
    }
}
