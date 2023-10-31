package racingcar;

import java.util.List;

public class InputFactory {

    public List<Car> getCars(String names) {
        CarFactory carFactory = new CarFactory();
        return carFactory.createCarsFromInput(names);
    }

    public int getRacingRound(String round) {
        int roundNumber = parseRoundNumber(round);
        validatePositiveNumber(roundNumber);
        return roundNumber;
    }

    public int parseRoundNumber(String round) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }
}
