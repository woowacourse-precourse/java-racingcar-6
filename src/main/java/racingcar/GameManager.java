package racingcar;

import static racingcar.Validator.isNotValidInput;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        String regex = "^[A-Za-z가-힣]{1,5}(,[A-Za-z가-힣]{1,5}){1,}$";
        if (isNotValidInput(carNames, regex)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 영어 또는 한글만 가능합니다. 쉼표(,)로 구분하여 두 대 이상 입력해주세요.");
        }
        return carNames;
    }

    public int askTryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");

        int tryCount = 0;
        try {
            tryCount = Integer.parseInt(Console.readLine());
            if (tryCount < 1) {
                throw new IllegalArgumentException("시도할 횟수는 1회 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수로 숫자를 입력해주세요.");
        }
        return tryCount;
    }
}
