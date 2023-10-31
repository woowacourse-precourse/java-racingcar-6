package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static String carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return read();
    }

    public static String attemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return read();
    }

    public static String read() {
        return readLine();
    }
}
