package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class RacingCarConsole {
    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("자동차의 이름을 정해주세요.");
        }
    }
}
