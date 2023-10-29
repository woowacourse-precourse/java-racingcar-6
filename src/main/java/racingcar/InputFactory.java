package racingcar;

import java.util.List;

public class InputFactory {

    public static List<Car> getCars(String names) {
        ResultView.printEnterNameGuide();
        return CarFactory.createCarsFromInput(names);
    }

    public static int getRacingRound(String round) {
        ResultView.printRoundQuestion();
        int roundNumber = parseRoundNumber(round);
        validatePositiveNumber(roundNumber);
        return roundNumber;
    }

    public static int parseRoundNumber(String round) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }
}
