package racingcar;

import java.util.Arrays;
import java.util.List;

public class UserInput {
    public List<String> getCarNames(String carNames) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.asList(carNames.split(","));
    }

    public int getAttemptsNumber(String inputNumber) {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자만 가능합니다.");
        }
    }
}
