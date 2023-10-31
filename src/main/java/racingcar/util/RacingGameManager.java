package racingcar.util;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameManager {

    private List<Car> carList;

    public RacingGameManager(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> createCarListFromPlayerInput(String playerInput) {
        String[] carNames = playerInput.split(",");
        validateCarNames(carNames);

        return carList = Arrays.stream(carNames)
                .map(carName -> new Car(carName.trim(), 0))
                .collect(Collectors.toList());
    }

    public int createCountFromPlayerInput(String playerInput) {
        validateCounts(playerInput);
        return Integer.parseInt(playerInput);
    }

    private void validateCarNames(String[] carNames) {
        validateCarNamesUnderFive(carNames);
        validateDuplicatedCarName(carNames);
        validateEmptyCarName(carNames);
    }

    private void validateCarNamesUnderFive(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("차의 이름은 5자 이하로 입력해주세요. 자동차 경주 게임을 종료합니다.");
            }
        }
    }

    private void validateDuplicatedCarName(String[] carNames) {
        long uniqueCarNameCount = Arrays.stream(carNames)
                .distinct()
                .count();
        if (uniqueCarNameCount != carNames.length) {
            throw new IllegalArgumentException("차의 이름은 중복될 수 없습니다. 자동차 경주 게임을 종료합니다.");
        }
    }

    private void validateEmptyCarName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("공백은 입력될 수 없습니다. 자동차 경주 게임을 종료합니다.");
            }
        }
    }

    private void validateCounts(String playerInput) {
        try {
            int count = Integer.parseInt(playerInput);
            if (count < 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다. 자동차 경주 게임을 종료합니다.");
        }
    }
}
