package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameView {

    private static final String NAME_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_GUIDE = "시도할 회수는 몇회인가요?";
    private static final String ERROR_NAME_LENGTH = "이름은 5글자 이하만 가능합니다.";
    private static final int MAX_NAME_LENGTH = 5;

    public String inputCarNames() {
        System.out.println(NAME_INPUT_GUIDE);
        String carNames = Console.readLine();
        validateCarNames(carNames);
        return carNames;
    }

    public void validateCarNames(String input) {
        String[] result = input.split(",");

        for (String name : result) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ERROR_NAME_LENGTH);
            }
        }
    }

    public int inputGameRounds() {
        System.out.println(ROUND_INPUT_GUIDE);
        String rounds = Console.readLine();
        validatePositiveNumber(rounds);
        return Integer.parseInt(rounds);
    }

    public void validatePositiveNumber(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("입력 값은 1 이상의 숫자여야 합니다.");
        }
    }
}
