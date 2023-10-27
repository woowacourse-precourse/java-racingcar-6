package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputImpl implements Input {
    private static final int MAX_NAME_LENGTH = 5;
    
    @Override
    public List<String> carName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = validateCarNames(input);
        return carNames;
    }

    @Override
    public int attemptsNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return validateAttemptsNumber(input);
    }
    
    private int validateAttemptsNumber(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 0이상이어야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }
    
    private List<String> validateCarNames(String input) {
        String[] carNamesArray = input.split(",");
        List<String> carNames = new ArrayList<>();

        for (String name : carNamesArray) {
            String trimmedName = name.trim();
            validateNameLength(trimmedName);
            carNames.add(trimmedName);
        }

        validateCarNamesCount(carNames);
        validateNoSpaces(input);

        return carNames;
    }
    
    private boolean validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        return true;
    }

    private void validateCarNamesCount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차 이름은 2개 이상이어야 합니다.");
        }
    }

    private void validateNoSpaces(String input) {
        String trimmedInput = input.trim();
        if (trimmedInput.endsWith(",")) {
            throw new IllegalArgumentException("이름 뒤에 공백이 올 수 없습니다.");
        }
    }
}

