package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int getRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return validateRoundsInput(Console.readLine());
    }

    private static int validateRoundsInput(String roundsInput) {
        try {
            int rounds = Integer.parseInt(roundsInput);
            if (rounds <= 0) {
                throw new IllegalArgumentException("라운드 수는 1 이상의 정수여야 합니다.");
            }
            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("라운드 수는 정수여야 합니다.");
        }
    }
}
