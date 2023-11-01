package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAMES_REQUEST_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUNDS_REQUEST_MSG = "시도할 회수는 몇회인가요?";

    public static String getCarNames() {
        System.out.println(CAR_NAMES_REQUEST_MSG);

        String carNames = Console.readLine();
        validateCarNamesInput(carNames);

        return carNames;
    }

    public static int getRounds() {
        System.out.println(ROUNDS_REQUEST_MSG);

        String rounds = Console.readLine();
        validateRoundsInput(rounds);

        return Integer.parseInt(rounds);
    }

    private static void validateCarNamesInput(String carNamesInput) {
        if (carNamesInput == null || carNamesInput.trim().isEmpty()) {
            throw new IllegalArgumentException("경주에 참가할 자동차들을 입력해야 합니다.");
        }
    }

    private static void validateRoundsInput(String roundsInput) {
        if (roundsInput == null || roundsInput.trim().isEmpty()) {
            throw new IllegalArgumentException("라운드 수를 입력해야 합니다.");
        }
        try {
            Integer.parseInt(roundsInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("라운드 수는 정수여야 합니다.");
        }
    }
}
