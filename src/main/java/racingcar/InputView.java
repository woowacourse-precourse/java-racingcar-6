package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class InputView {
    private static final String carNameErrorMessage = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String CAR_NAME_RULE = "^[a-z]{1,5}$";
    String userInput = Console.readLine();
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = userInput.split(",");

        for (String carName : carNames) {
            if (carName.length() > 5 || !carName.matches(CAR_NAME_RULE)) {
                throw new IllegalArgumentException(carNameErrorMessage);
            }
        }

        return List.of(carNames);
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int tryCount = Integer.parseInt(userInput);
            if (tryCount < 1) {
                throw new IllegalArgumentException("시도할 횟수는 1회 이상이어야 합니다.");
            }
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 합니다.");
        }
    }
}
