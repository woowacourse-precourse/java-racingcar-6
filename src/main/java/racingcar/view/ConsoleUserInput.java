package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleUserInput extends UserInput {
    @Override
    public String[] readCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        validateCarNames(carNames);
        return carNames;
    }

    @Override
    public int readNumberOfAttempts() {
        String input = Console.readLine();
        int numberOfAttempts = validateNumberOfAttempts(input);
        return numberOfAttempts;
    }

    private void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.trim().isEmpty()) {
                throw new RacingGameException("자동차 이름을 입력해야 합니다.");
            }
        }

        for (int i = 0; i < carNames.length - 1; i++) {
            for (int j = i + 1; j < carNames.length; j++) {
                if (carNames[i].trim().equals(carNames[j].trim())) {
                    throw new RacingGameException("중복된 자동차 이름이 있습니다.");
                }
            }
        }
    }

    private int validateNumberOfAttempts(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number < 1 || number > 9) {
                throw new RacingGameException("1~9 사이의 횟수를 입력해야 합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new RacingGameException("올바른 숫자를 입력해야 합니다.");
        }
    }
}

