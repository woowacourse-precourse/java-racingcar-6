package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class ConsoleProvider implements InputProvider {
    @Override
    public String provide() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("입력 중 문제가 발생했습니다.", e);
        }
    }
}
