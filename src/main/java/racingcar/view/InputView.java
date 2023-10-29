package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    public int getAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return parseInt(readLine());
    }

    public List<String> getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return List.of(readLine().split(","));
    }

    private String readLine() {
        return Console.readLine();
    }

    private int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }
}
