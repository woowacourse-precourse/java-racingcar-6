package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public static List<Car> getCars() {
        ResultView.printEnterNameGuide();
        return CarFactory.createCarsFromInput(Console.readLine());
    }

    public static int getRacingRound() {
        ResultView.printRoundQuestion();
        int round = parseRoundNumber();
        validatePositiveNumber(round);
        return round;
    }

    private static int parseRoundNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }
}
