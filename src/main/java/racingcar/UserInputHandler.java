package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInputHandler {
    List<String> cars = new ArrayList<>();

    public List<String> getUserCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        userInputVerification(userInput);

        String[] carNames = userInput.split(",");
        cars.addAll(Arrays.asList(carNames));

        return cars;
    }

    // 자동차 이름 검증 함수들
    private void userInputVerification(String userInput) {
        validateInputNotEmpty(userInput);
        String[] carNames = userInput.split(",");
        duplicateCarNames(carNames);
        validateCarNames(carNames);
    }

    // 중복된 입력 검사
    public void duplicateCarNames(String[] userInput) {
        for (int i = 0; i < userInput.length - 1; i++) {
            if (userInput[i].contains(userInput[i + 1])) {
                throw new IllegalArgumentException("중복된 입력이 발생했습니다.");
            }
        }
    }

    // 공백 입력 검사
    public void validateInputNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("입력이 없습니다.");
        }
    }

    // 5글자 이하 검사
    public void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("차의 이름은 5글자 이하이어야 합니다.");
            }
        }
    }

    // 시도할 횟수 입력
    public long getUserCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String userCount = Console.readLine();
        validateInputNotEmpty(userCount);
        validateNotLongNumber(userCount);

        return Long.parseLong(userCount);
    }

    // 횟수가 숫자로 입력되었는지 확인
    private void validateNotLongNumber(String userCount) {
        try {
            Long.parseLong(userCount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자가 입력되어야 합니다.");
        }

    }
}