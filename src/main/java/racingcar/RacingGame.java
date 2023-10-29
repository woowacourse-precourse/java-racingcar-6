package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RacingGame {

    public RacingGame() {

    }

    public void start() {
        printCarNameInputMessages();
        List<String> carNames = getCarNames();

    }

    private void printCarNameInputMessages() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    private List<String> getCarNames() throws IllegalArgumentException {
        String strNames = Console.readLine();
        if (Objects.isNull(strNames)) {
            throw new IllegalArgumentException("자동차들의 이름은 NULL이 될 수 없습니다.");
        }
        return Arrays.asList(strNames.split(","));
    }

}
